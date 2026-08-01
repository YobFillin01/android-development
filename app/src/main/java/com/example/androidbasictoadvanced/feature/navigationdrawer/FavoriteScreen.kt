package com.example.androidbasictoadvanced.feature.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Orange40


data class FavoriteItem(
    val transfer: String,
    val receiverAccount: String,
    val transaction: TransactionType
)

enum class TransactionType {
    Transfer,
    Receive,
    Payment,
    BillPayment,
    TopUp,
    CashIn,
    CashOut,
    Salary,
    Refund
}

val transferList = listOf(
    FavoriteItem(
        "Transfer to Lim Hasanas",
        "ABA **** 4567",
        TransactionType.Transfer
    ),
    FavoriteItem(
        "Receive from Sok Dara",
        "ACLEDA **** 1234",
        TransactionType.Receive
    ),
    FavoriteItem(
        "Coffee at Brown Coffee",
        "ABA KHQR",
        TransactionType.Payment
    ),
    FavoriteItem(
        "Electricity Bill",
        "EDC Cambodia",
        TransactionType.BillPayment
    ),
    FavoriteItem(
        "Smart Top-Up",
        "012 345 678",
        TransactionType.TopUp
    ),
    FavoriteItem(
        "Cash Deposit",
        "ABA Branch",
        TransactionType.CashIn
    ),
    FavoriteItem(
        "ATM Withdrawal",
        "ABA ATM",
        TransactionType.CashOut
    ),
    FavoriteItem(
        "Monthly Salary",
        "ABC Technology Co.",
        TransactionType.Salary
    ),
    FavoriteItem(
        "Refund from Food Delivery",
        "Nham24",
        TransactionType.Refund
    ),
    FavoriteItem(
        "Transfer to Chan Vanna",
        "ABA **** 5678",
        TransactionType.Transfer
    ),
    FavoriteItem(
        "Receive from Heng Rithy",
        "Wing **** 9876",
        TransactionType.Receive
    ),
    FavoriteItem(
        "Lunch at Pizza Company",
        "Visa Debit",
        TransactionType.Payment
    ),
    FavoriteItem(
        "Internet Bill",
        "Metfone",
        TransactionType.BillPayment
    ),
    FavoriteItem(
        "Cellcard Top-Up",
        "089 111 222",
        TransactionType.TopUp
    ),
    FavoriteItem(
        "Cash Deposit",
        "ACLEDA Branch",
        TransactionType.CashIn
    ),
    FavoriteItem(
        "Cash Withdrawal",
        "Wing Agent",
        TransactionType.CashOut
    ),
    FavoriteItem(
        "Transfer to Kim Sopheak",
        "Wing **** 7654",
        TransactionType.Transfer
    ),
    FavoriteItem(
        "Receive from Makara",
        "TrueMoney **** 6060",
        TransactionType.Receive
    ),
    FavoriteItem(
        "Refund from Online Store",
        "Shop App",
        TransactionType.Refund
    ),
    FavoriteItem(
        "Monthly Salary",
        "XYZ Solutions",
        TransactionType.Salary
    )
)
@Composable
fun FavoriteScreen() {

    val transfer = transferList

    Column(

        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xFFD1D1D1))
            .padding(16.dp)

    ) {
        
        Row(

            verticalAlignment = Alignment.CenterVertically

        ) {
            IconButton(
                onClick = {
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "Back"
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Favorites",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(

        ) {
            items(transfer) { item ->
                Column(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center

                ) {
                    Row(

                        modifier = Modifier
                            .fillMaxWidth(),
                        ) {

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(50.dp),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Green.copy(alpha = 0.2f)
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_transfer),
                                contentDescription = "Transfer",
                                tint = Color.Black
                            )
                        }

                        Column(

                            modifier = Modifier
                                .padding(start = 16.dp),
                            verticalArrangement = Arrangement.Center

                        ) {
                            Text(
                                text = item.transfer
                            )

                            Text(
                                text = item.receiverAccount,
                                fontSize = 12.sp,
                                color = Color.Black.copy(alpha = 0.5f)
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = item.transaction.toString(),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .padding(top = 12.dp),
                            color = Color.Black.copy(alpha = 0.5f)
                        )

                    }

                }
            }
        }

    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun FavoriteScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        FavoriteScreen()
    }
}