package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Assignment
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenLoan(
    onBack:() -> Unit
) {


    Column(
        modifier = Modifier
            .background(Color(0xFF0D3157))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    onBack()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back_new),
                    contentDescription = null,
                    tint = Color.White
                )
            }

//            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Loans",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0D3157))
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                // Coin is now INSIDE LazyColumn
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_coin),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color.White
                        )
                    }
                }

                // White content area
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 16.dp
                                )
                            )
                            .background(Color.White)
                            .padding(16.dp)
                    ) {

                        loanCategories.forEach { loan ->
                            LoanCard(
                                loan = loan
                            )
                        }

                        otherServices.forEach { service ->
                            OtherServiceCard(
                                otherService = service
                            )
                        }
                    }
                }
            }
        }

    }
}

data class Loan(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val category: LoanCategory
)

enum class LoanCategory {
    LOAN,
    OTHER_SERVICE
}

val loanCategories = listOf(

    Loan(
        title = "BNPL Loans",
        description = "You can estimate loan payments, interest costs, and repayment schedules before applying for a loan.",
        icon = Icons.Outlined.Payments,
        category = LoanCategory.LOAN
    ),

    Loan(
        title = "Merchant Loan",
        description = "ACLEDA Bank's merchants can apply for a loan based on their business's daily transaction volume.",
        icon = Icons.Outlined.ShoppingCart,
        category = LoanCategory.LOAN
    ),

    Loan(
        title = "Loan Against Term Deposit",
        description = "You will receive instant loan up to 97% of the fixed deposit.",
        icon = Icons.Outlined.AccountBalance,
        category = LoanCategory.LOAN
    ),

    Loan(
        title = "Salary Loan",
        description = "Civil servants can get up to 40M Riel / Private company employees can get up to 40M Riel.",
        icon = Icons.Outlined.AttachMoney,
        category = LoanCategory.LOAN
    ),

    Loan(
        title = "Advance Salary Loan",
        description = "You can advance up to 50% of your salary immediately.",
        icon = Icons.Outlined.RequestQuote,
        category = LoanCategory.LOAN
    )
)

val otherServices = listOf(

    Loan(
        title = "Advance Salary Loan",
        description = "You can advance up to 50% of your salary immediately.",
        icon = Icons.Outlined.RequestQuote,
        category = LoanCategory.OTHER_SERVICE
    ),

    Loan(
        title = "Loan Application",
        description = "The credit officer will visit you for preparing loan documents at your place.",
        icon = Icons.Outlined.Assignment,
        category = LoanCategory.OTHER_SERVICE
    ),

    Loan(
        title = "Loan Calculator",
        description = "Estimate loan payments, interest costs, and repayment schedules before applying for a loan.",
        icon = Icons.Outlined.Calculate,
        category = LoanCategory.OTHER_SERVICE
    ),

    Loan(
        title = "Loan Summary",
        description = "You can check the loan information and payment schedule.",
        icon = Icons.Outlined.Description,
        category = LoanCategory.OTHER_SERVICE
    ),

    Loan(
        title = "CBC Credit Report",
        description = "Your personal financial health checking, powered by CBC.",
        icon = Icons.Outlined.AccountBalance,
        category = LoanCategory.OTHER_SERVICE
    ),

    Loan(
        title = "Digital Loan Documents",
        description = "You can review and sign the loan contract anytime, anywhere via mobile.",
        icon = Icons.Outlined.Edit,
        category = LoanCategory.OTHER_SERVICE
    )
)

@Composable
fun LoanCard(
    loan: Loan
) {

    ElevatedCard(

        modifier = Modifier
            .padding(vertical = 8.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = loan.icon,
                contentDescription = loan.title,
                tint = Color.Blue
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = loan.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = loan.description,
                    color = Color.Gray
                )
            }
        }
    }

}

@Composable
fun OtherServiceCard(
    otherService: Loan
) {

    ElevatedCard(

        modifier = Modifier
            .padding(vertical = 8.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = otherService.icon,
                contentDescription = otherService.title,
                tint = Color.Blue
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = otherService.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = otherService.description,
                    color = Color.Gray
                )
            }
        }
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenLoanPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenLoan {}
    }
}