package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.practice.screenUI.ItemFirstRow
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

data class ItemModel(
    val icon: Int,
    val title: String,
    val onClick:() -> Unit
)

@Composable
fun ScreenHomeAceleda(
    onProfileClick: () -> Unit = {},
    onNavigateToPayment: () -> Unit,
    onNavigateToMobileTopUp: () -> Unit,
    onNavigateToCards: () -> Unit,
    onNavigateToQr: () -> Unit,
    onNavigateToTransfer: () -> Unit,
    onNavigateToDeposit: () -> Unit,
    onNavigateToLoan: () -> Unit,
    onNavigateToQuickCash: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D3157))
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    onProfileClick()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier.size(64.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_my_picture),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Hello, FILLIN",
                    color = Color.White,
//                fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Profile", color = Color.Gray)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_forward_arrow),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Gray
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        var isMoneyVisible by remember { mutableStateOf(false) }

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 16.dp),
            border = BorderStroke(1.dp, color = Color(0xFF1B5FB3)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF062141)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
//            verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF062141))
                        .drawBehind {

                            // Blue left border
                            drawArc(
                                color = Color(0xFF2A84FA),
                                startAngle = 90f,
                                sweepAngle = 180f,
                                useCenter = false,
                                style = Stroke(width = 6.dp.toPx())
                            )

                            // Yellow right border
                            drawArc(
                                color = Color(0xFFBF9A33),
                                startAngle = -90f,
                                sweepAngle = 180f,
                                useCenter = false,
                                style = Stroke(width = 6.dp.toPx())
                            )
                        }
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_acc_wallet),
                                contentDescription = null,
                                tint = Color(0xFFBF9A33),
                                modifier = Modifier.size(50.dp)
                            )
                        }

                        Text(
                            text = "Accounts",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Column {
                    Row(
                        modifier = Modifier.padding(end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Total Balances",
                            color = Color.Gray
                        )

                        IconButton(
                            onClick = { isMoneyVisible = !isMoneyVisible },
                        ) {
                            Icon(
                                painter = painterResource(
                                    if (isMoneyVisible) R.drawable.ic_eyes else R.drawable.ic_eye_visibility
                                ),
                                contentDescription = null,
                                tint = Color.Gray,
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(start = 24.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "1,000,000,000",
                            color = Color.White,
                            modifier = if (isMoneyVisible) {
                                Modifier
                            } else {
                                Modifier.blur(8.dp)
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "៛",
                            color = Color(0xFFBF9A33),
                            fontSize = 24.sp
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 24.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "1,000,000,000",
                            color = Color.White,
                            modifier = if (isMoneyVisible) {
                                Modifier
                            } else {
                                Modifier.blur(8.dp)
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "$",
                            color = Color(0xFF2A84FA),
                            fontSize = 20.sp
                        )
                    }

                }


            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val listFirstRow = listOf(
            ItemModel(R.drawable.ic_card, "Cards", onNavigateToCards),
            ItemModel(R.drawable.ic_qr_scanner, "Scan QR", onNavigateToQr),
            ItemModel(R.drawable.ic_transfer, "Transfers", onNavigateToTransfer),
        )

        val listSecondRow = listOf(
            ItemModel(R.drawable.ic_finance_mode, "Deposits", onNavigateToDeposit),
            ItemModel(R.drawable.ic_loans, "Loans", onNavigateToLoan),
            ItemModel(R.drawable.ic_deposit, "Quick Cash", onNavigateToQuickCash),
        )



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .width(185.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF062141))
                        .border(
                            1.dp,
                            color = Color(0xFF1B5FB3),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {
                                onNavigateToPayment()
                            })
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_bills),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFFBF9A33)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Payments",
                            color = Color.White,
                            fontSize = 16.sp
                        )

                    }
                }

                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .width(185.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF062141))
                        .border(
                            1.dp,
                            color = Color(0xFF1B5FB3),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {
                                onNavigateToMobileTopUp()
                            })
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_mobile),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFFBF9A33)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Mobile Top-up",
                            color = Color.White,
                            fontSize = 16.sp
                        )

                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                listFirstRow.forEach { item ->
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF062141))
                            .border(
                                1.dp,
                                color = Color(0xFF1B5FB3),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(

                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            IconButton(
                                onClick = item.onClick
                            ) {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = null,
                                    tint = Color(0xFFBF9A33),
                                    modifier = Modifier.size(35.dp)
                                )
                            }

                            Text(
                                text = item.title,
                                color = Color.White
                            )
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                listSecondRow.forEach { item ->
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF062141))
                            .border(
                                1.dp,
                                color = Color(0xFF1B5FB3),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(

                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            IconButton(
                                onClick = item.onClick
                            ) {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = null,
                                    tint = Color(0xFFBF9A33),
                                    modifier = Modifier.size(35.dp)
                                )
                            }

                            Text(
                                text = item.title,
                                color = Color.White
                            )
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            val listItem = listOf(
                ItemFirstRow(R.drawable.ic_coin, "My Points"),
                ItemFirstRow(R.drawable.ic_info, "Information"),
                ItemFirstRow(R.drawable.ic_share, "Share"),
                ItemFirstRow(R.drawable.ic_public, "Public"),
                ItemFirstRow(R.drawable.ic_account_balance, "Market"),
                ItemFirstRow(R.drawable.ic_investment, "Exchange"),
                ItemFirstRow(R.drawable.ic_saving, "Saving"),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
//                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF062141))
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically
            ) {

                listItem.forEach { item ->
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .size(64.dp)
                                .background(Color(0xFF062141))
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF1B5FB3),
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = null,
                                    tint = Color(0xFFBF9A33),
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Text(
                            text = item.title,
                            color = Color.White
                        )
                    }
                }


            }

        }

        ScreenRecommend()
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenHomeAceledaPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenHomeAceleda(
            onNavigateToPayment = {},
            onNavigateToMobileTopUp = {},
            onNavigateToCards = {},
            onNavigateToQr = {},
            onNavigateToTransfer = {},
            onNavigateToDeposit = {},
            onNavigateToLoan = {},
            onNavigateToQuickCash = {}
        )
    }
}