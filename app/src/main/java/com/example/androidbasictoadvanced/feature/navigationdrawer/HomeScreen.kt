package com.example.androidbasictoadvanced.feature.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme



data class ServiceModel(
    val icon: Int,
    val title: String,
    val subTitle: String
)

val serviceList = listOf(
    ServiceModel(
        R.drawable.ic_account_balance,
        "Accounts",
        "View your bank account"
    ),
    ServiceModel(
        R.drawable.ic_transfer,
        "Transfer",
        "Send money securely"
    ),
    ServiceModel(
        R.drawable.ic_payment,
        "Payments",
        "Pay your bills easily"
    ),
    ServiceModel(
        R.drawable.ic_card,
        "Cards",
        "Manage your debit and credit cards"
    ),
    ServiceModel(
        R.drawable.ic_saving,
        "Savings",
        "Track your savings goals"
    ),
    ServiceModel(
        R.drawable.ic_loans,
        "Loans",
        "View and manage your loans"
    ),
    ServiceModel(
        R.drawable.ic_investment,
        "Investments",
        "Monitor your investment portfolio"
    ),
    ServiceModel(
        R.drawable.ic_history,
        "Transactions",
        "Review your transaction history"
    ),
    ServiceModel(
        R.drawable.ic_transaction,
        "Notifications",
        "Stay updated with account alerts"
    ),
)


@Composable
fun HomeScreen(
    onProfileClick: () -> Unit = {}
) {

    val service = serviceList

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xFFD1D1D1))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{
                    onProfileClick()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_my_picture),
                contentDescription = "My picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))

            Text(
                text = "Welcome, Fillin",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color(0xFF007AE3))

        ) {
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(
                    text = "Total Balance",
                    color = Color.White.copy(alpha = 0.5f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$ 9,9999.00",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Saving Account **** 1234",
                    color = Color.White.copy(alpha = 0.5f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Quick Actions",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(

            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column(

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Red.copy(alpha = 0.2f)
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_transfer2),
                        contentDescription = "Transfer",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Transfer",
                    fontSize = 12.sp
                )


            }

            Column(

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Green.copy(alpha = 0.2f)
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_qr_scanner),
                        contentDescription = "Scan",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Scan KHQR",
                    fontSize = 12.sp
                )


            }

            Column(

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Blue.copy(alpha = 0.2f)
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_card),
                        contentDescription = "Payment",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Payment",
                    fontSize = 12.sp
                )


            }

            Column(

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Cyan.copy(alpha = 0.2f)
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_mobile),
                        contentDescription = "Top Up",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Top Up",
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Services",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            service.forEach { service ->

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(service.icon),
                            contentDescription = "Account",
                            modifier = Modifier
                                .size(32.dp),
                            tint = Color(0xFF007AE3)
                        )
                    }

                    Column(

                        modifier = Modifier
                            .padding(start = 16.dp)

                    ) {
                        Text(
                            text = service.title
                        )

                        Text(
                            text = service.subTitle,
                            fontSize = 12.sp,
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
fun HomeScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        HomeScreen()
    }
}