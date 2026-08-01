package com.example.androidbasictoadvanced.feature.navigationbar

import androidx.compose.foundation.background
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


@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xFFD1D1D1))
            .padding(16.dp)
    ) {

        Text(
            text = "Welcome, Fillin",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color(0xFF2357A8))

        ) {
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(
                    text = "Total Balance",
                    color = Color.White.copy(alpha = 0.7f)
                )

                Text(
                    text = "$ 9,9999.00",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Saving Account **** 1234",
                    color = Color.White.copy(alpha = 0.7f)
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
                    shape = RoundedCornerShape(16.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_transfer2),
                        contentDescription = "Transfer",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF2357A8)
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
                    shape = RoundedCornerShape(16.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_qr_scanner),
                        contentDescription = "Scan",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF004CBA)
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
                    shape = RoundedCornerShape(16.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_card),
                        contentDescription = "Payment",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF004CBA)
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
                    shape = RoundedCornerShape(16.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_mobile),
                        contentDescription = "Top Up",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF004CBA)
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
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
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
                        painter = painterResource(R.drawable.ic_account_balance),
                        contentDescription = "Account",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF2357A8)
                    )
                }

                Column(

                    modifier = Modifier
                        .padding(start = 16.dp)

                ) {
                    Text(
                        text = "Accounts"
                    )

                    Text(
                        text = "View Your bank accounts",
                        fontSize = 12.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                }
            }

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
                        painter = painterResource(R.drawable.ic_transaction),
                        contentDescription = "Transactions",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF004CBA)
                    )
                }

                Column(

                    modifier = Modifier
                        .padding(start = 16.dp)

                ) {
                    Text(
                        text = "Transactions"
                    )

                    Text(
                        text = "Check recent activities",
                        fontSize = 12.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                }
            }

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
                        painter = painterResource(R.drawable.ic_card),
                        contentDescription = "Card",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color(0xFF004CBA)
                    )
                }

                Column(

                    modifier = Modifier
                        .padding(start = 16.dp)

                ) {
                    Text(
                        text = "Card"
                    )

                    Text(
                        text = "Manage your debit cards",
                        fontSize = 12.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
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