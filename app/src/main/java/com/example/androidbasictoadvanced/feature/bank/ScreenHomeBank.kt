package com.example.androidbasictoadvanced.feature.bank

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ScreenHomeBank(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(

                modifier = Modifier
                    .padding(horizontal = 16.dp),

                title = {
                    Column {
                        Text(
                            text = "Account",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "គណនី",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            AccountBalance()

            Buttons()

            AccountHistory()

        }
    }
}

@Composable
fun AccountBalance() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF05004F))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Text(
                text = "Total Balance",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$23,140.50",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray.copy(alpha = 0.5f))
                        .width(150.dp)
                        .height(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(
                            text = "USD : ដុល្លា",
                            color = Color.LightGray
                        )

                        Text(
                            text = "$15,695.50",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray.copy(alpha = 0.5f))
                        .width(150.dp)
                        .height(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(
                            text = "KHR : រៀល",
                            color = Color.LightGray
                        )

                        Text(
                            text = "29,780,000រ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Converted at $1 = 4,000រៀល (sample rate)",
                color = Color.LightGray,
            )
        }
    }
}

@Composable
fun Buttons() {
    val buttons = buttonList
    var selectedIndex by remember { mutableIntStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        buttons.forEachIndexed { index, button ->
            OutlinedButton(
                onClick = {
                    selectedIndex = index
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedIndex == index) Color.Black else Color.White,
                    contentColor = if (selectedIndex == index) Color.White else Color.Black
                )
            ) {
                Text(
                    text = button.text
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }


    }
}

@Composable
fun AccountHistory() {

    val accountDollars = accountDollarList
    val accountKhmer = accountKhmerList

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
//            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "US DOLLAR : ដុល្លា",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "2 accounts"
                )
            }

            accountDollars.forEach { accountDollarList ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = Color(0xFF1910C9).copy(0.2f),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(accountDollarList.icons),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape),
                                tint = Color(0xFF1910C9)
                            )
                        }


                        Spacer(modifier = Modifier.width(16.dp))

                        Column(

                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = accountDollarList.title,
                                    color = Color.Black,
                                    fontSize = 24.sp
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Text(
                                    text = accountDollarList.amount,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = accountDollarList.subTitle,
                                    color = Color.Gray,
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Text(
                                    text = accountDollarList.status,
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "KHMER RIEL : រៀល",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "2 accounts"
                )
            }

            accountKhmer.forEach { accountKhmerList ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = Color(0xFF9E8809).copy(0.2f),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(accountKhmerList.icons),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape),
                                tint = Color(0xFF9E8809)
                            )
                        }


                        Spacer(modifier = Modifier.width(16.dp))

                        Column(

                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = accountKhmerList.title,
                                    color = Color.Black,
                                    fontSize = 24.sp
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Text(
                                    text = accountKhmerList.amount,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = accountKhmerList.subTitle,
                                    color = Color.Gray,
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Text(
                                    text = accountKhmerList.status,
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenHomeBankPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenHomeBank(
            onBack = {}
        )
    }
}