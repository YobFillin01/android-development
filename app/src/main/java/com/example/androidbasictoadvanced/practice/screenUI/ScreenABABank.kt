package com.example.androidbasictoadvanced.practice.screenUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Brown40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenABABank() {

    Scaffold(
        containerColor = Color(0xFF4A4A4A),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                title = {
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                    ) {

                        Text(
                            text = "ទិវាសួរស្តី!",
                            fontSize = 14.sp
                        )

                        Text(
                            text = "Yob Fillin",
                            fontWeight = FontWeight.Bold
                        )
                    }
                },

                navigationIcon = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(
                                color = Color.Black
                            )
                            .size(40.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = "Profile",
                            tint = Color.White,
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_chat),
                            contentDescription = "Chat",
                            tint = Color.White,
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notifications",
                            tint = Color.White,
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_card),
                            contentDescription = "Cards",
                            tint = Color.White,
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(Color.Red)
                            .size(35.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_qr_code),
                            contentDescription = "Chat",
                            tint = Color.White,
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4A4A4A),
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            DashBoardScreen()
            Spacer(modifier = Modifier.height(16.dp))
            Component()
            Spacer(modifier = Modifier.height(16.dp))
            Promotions()
            Spacer(modifier = Modifier.height(16.dp))
            PromotionImage()
        }
    }

}

@Composable
fun DashBoardScreen() {
    Box(
        modifier = Modifier
            .height(180.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Red.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        start = 16.dp
                    )
                    .clip(RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "$100 000",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(
                            Color.White.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_eyes),
                        contentDescription = "Secret",
                        tint = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp
                    )
            ) {
                Text(
                    text = "  គណនាគោល  ",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Savings",
                    color = Color.White.copy(alpha = 0.8f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Text(
                    text = "ទទួលលុយ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Text(
                    text = "ផ្ញើលុយ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(32.dp))

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Text(
                    text = "វិភាគ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun Component() {

    Column(
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
           Column(
               modifier = Modifier
                   .size(
                       width = 110.dp,
                       height = 90.dp
                   )
                   .clip(
                       RoundedCornerShape(16.dp)
                   )
                   .background(
                       Color.Black
                   ),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               IconButton(
                   onClick = {}
               ) {
                   Icon(
                       painter = painterResource(R.drawable.ic_favorite),
                       contentDescription = null,
                       tint = Color.White
                   )
               }
               Text(
                   text = "Hello",
                   color = Color.White
               )
           }

            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 90.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(
                        Color.Black
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 90.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(
                        Color.Black
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 90.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(
                        Color.Black
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 90.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(
                        Color.Black
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 90.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(
                        Color.Black
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .width(24.dp)
                .height(0.5.dp)
                .background(Color.White.copy(alpha = 0.5f))
        ) { }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .size(
                        height = 60.dp,
                        width = 140.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                modifier = Modifier
                    .size(
                        height = 60.dp,
                        width = 140.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                modifier = Modifier
                    .size(
                        height = 60.dp,
                        width = 140.dp
                    )
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hello",
                    color = Color.White
                )

            }
        }
    }
}

@Composable
fun Promotions() {
    Column(

        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Notifications & Promotions",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun PromotionImage() {

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(horizontal = 16.dp)
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(Color.White)

    ) {
        Image(
            painter = painterResource(R.drawable.img_aba_promotion),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenABABankPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenABABank()
    }
}