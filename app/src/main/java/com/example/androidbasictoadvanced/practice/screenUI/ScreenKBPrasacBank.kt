package com.example.androidbasictoadvanced.practice.screenUI


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Brown80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenKBPRASACBank(onBack:() -> Unit) {

    Scaffold(

        containerColor = Brown80,

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF736547)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFF8C8C8C)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_arrow_back),
                                contentDescription = "Bank",
                                tint = Color.White
                            )
                        }
                    }
                },

                title = {
                    Text(
                        text = "KB PRASAC Bank",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFF8C8C8C)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = "Notification",
                                tint = Color.White
                            )
                        }



                    }
                        IconButton(
                            onClick = {}
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color(0xFF8C8C8C)),
                                contentAlignment = Alignment.Center
                            ) {

                            }

                            Icon(
                                painter = painterResource(R.drawable.ic_qr_code),
                                contentDescription = "QR Code",
                                tint = Color.Red
                            )
                        }

                }
            )
        },

        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_home1),
                                contentDescription = "Home",
                                tint = Color.Gray,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Text(
                            text = "Home",
                            fontSize = 10.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_vdo_templates),
                                contentDescription = "Template",
                                tint = Color.Gray,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Text(
                            text = "Templates",
                            fontSize = 10.sp
                        )
                    }


                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(
                                Color(0xFFEBA742),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_qr_scanner),
                                contentDescription = "QR Code",
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.is_location),
                                contentDescription = "Location",
                                tint = Color.Gray,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Text(
                            text = "Locator",
                            fontSize = 10.sp
                        )
                    }


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_contact),
                                contentDescription = "Contact",
                                tint = Color.Gray,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Text(
                            text = "Contact",
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }

    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            CreditCard()
            //Spacer(modifier = Modifier.height(8.dp))
            BankingGrid()
            //Spacer(modifier = Modifier.height(8.dp))
            Information()

        }
    }

}

@Composable
fun Information() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.img_kbprasac),
            contentDescription = "KB PRASAC Bank",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun BankingGrid() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_account_balance,
                title = "Accounts"
            )

            VerticalLine()

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_acc_wallet,
                title = "Cards"
            )

            VerticalLine()

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_deposit,
                title = "Deposits"
            )
        }

        HorizontalLine()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_loans,
                title = "Loans"
            )

            VerticalLine()

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_cash_code,
                title = "Cash-Code"
            )

            VerticalLine()

            GridItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_mobile,
                title = "Top-Up"
            )
        }
    }
}

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String
) {

    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            painter = painterResource(icon),
            contentDescription = title,
            tint = Color(0xFFFFB300),
            modifier = Modifier.size(42.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}

@Composable
fun VerticalLine() {

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(Color.LightGray)
    )
}

@Composable
fun HorizontalLine() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}

@Composable
fun CreditCard() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color(0xFFEBA742)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Yob Fillin",
                    modifier = Modifier
                        .padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Digital Account",
                modifier = Modifier
                    .padding(start = 16.dp),
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$100 000",
                    modifier = Modifier
                        .padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_eyes),
                        contentDescription = "Eyes",
                        tint = Color(0xFFCF9102),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

//            Divider(
//                thickness = 0.5.dp,
//                color = Color.Black
//            )
            HorizontalDivider()

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {}
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp) // background size
                                .border(
                                    width = 2.dp, // thickness
                                    color = Color.Gray,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_transfer),
                                contentDescription = "Transfers",
                                tint = Color(0xFFCF9102),
                                modifier = Modifier.size(24.dp)// original icon size
                            )
                        }
                    }
                }
                Text(
                    text = "Transfers",
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Black)
                        .width(0.5.dp)
                ) { }

                IconButton(
                    onClick = {}
                ) {

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(
                                width = 2.dp,
                                color = Color.Gray,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_payment),
                            contentDescription = "Payments",
                            tint = Color(0xFFCF9102)
                        )
                    }


                }
                Text(
                    text = "Payments",
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenKBPrasacBankPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenKBPRASACBank {}
    }
}