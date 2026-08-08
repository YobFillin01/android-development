package com.example.androidbasictoadvanced.practice.screenUI

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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

data class Bottom(
    val icon: Int,
    val title: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenACELEDA() {

    val bottomList = listOf(
        Bottom(R.drawable.ic_home1, "Home"),
        Bottom(R.drawable.ic_favorite, "Favorite"),
        Bottom(R.drawable.ic_chat, "LiveChat"),
        Bottom(R.drawable.ic_menu, "Menu"),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(

        containerColor = Color(0xFF0D3157),

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "អេសុីលីដា",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0D3157),
                    titleContentColor = Color.White
                ),

                actions = {

                    BadgedBox(
                        badge = {
                            Badge(modifier = Modifier.size(8.dp))
                        }
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }


                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_qr_scanner),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF0D3157)
            ) {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    bottomList.forEachIndexed { index, bottom ->

                        Column(

                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            IconButton(
                                onClick = {
                                    selectedIndex = index
                                },
                                modifier = Modifier.width(64.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor =
                                        if (selectedIndex == index) Color(0xFFD4AF37).copy(alpha = 0.2f)
                                        else Color(0xFF0D3157),
                                    contentColor =
                                        if (selectedIndex == index) Color(0xFFD4AF37)
                                        else Color.White


                                )
                            ) {
                                Icon(
                                    painter = painterResource(bottom.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Text(
                                text = bottom.title,
                                fontSize = 12.sp,
                                color = if (selectedIndex == index) Color(0xFFD4AF37) else Color.White
                            )
                        }


                    }
                }

            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            MyProfile()
            Spacer(modifier = Modifier.height(8.dp))
            AccountCard()
            Spacer(modifier = Modifier.height(8.dp))
            Items()
            Spacer(modifier = Modifier.height(8.dp))
            AnotherFunction()

        }
    }

}

@Composable
fun MyProfile(onProfileClick: () -> Unit = {}) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable{
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

        Column(

        ) {
            Text(
                text = "Hello, FILLIN",
                color = Color.White,
//                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Profile", color = Color.White.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_forward_arrow),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.White.copy(alpha = 0.5f)
                )
            }
        }

    }

}

@Composable
fun AccountCard() {

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
                    .border(
                        width = 6.dp,
                        color = Color(0xFFD4A946),
                        shape = CircleShape
                    )
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
                            tint = Color.White,
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

            Column(

            ) {
                Row(
                    modifier = Modifier.padding(end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "Total Balances",
                        color = Color.White.copy(alpha = 0.5f)
                    )

                    IconButton(
                        onClick = {
                            isMoneyVisible = !isMoneyVisible
                        }
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
                    modifier = Modifier.padding(start = 70.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = if (isMoneyVisible) "1,000,000" else "●●●●●●",
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "៛",
                        color = Color(0xFFD4A946),
                        fontSize = 24.sp
                    )
                }

                Row(
                    modifier = Modifier.padding(start = 70.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = if (isMoneyVisible) "1,000,000" else "●●●●●●",
                        color = Color.White
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
}

data class ItemFirstRow(
    val icon: Int,
    val title: String
)

@Composable
fun Items() {

    val listFirstRow = listOf(
        ItemFirstRow(R.drawable.ic_card, "Card"),
        ItemFirstRow(R.drawable.ic_qr_code, "Scan QR"),
        ItemFirstRow(R.drawable.ic_transfer, "Transfer"),
    )

    val listSecondRow = listOf(
        ItemFirstRow(R.drawable.ic_finance_mode, "Deposits"),
        ItemFirstRow(R.drawable.ic_loans, "Loans"),
        ItemFirstRow(R.drawable.ic_deposit, "Quick Cash"),
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
                        .clickable(onClick = {})
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_bills),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
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
                        .clickable(onClick = {})
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_mobile),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
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
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
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
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
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

    }

}

@Composable
fun AnotherFunction() {

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
            .padding(horizontal = 16.dp)
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
                            tint = Color.White,
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

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenACELEDAPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenACELEDA()
    }
}