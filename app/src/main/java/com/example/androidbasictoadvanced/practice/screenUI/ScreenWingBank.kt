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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.BlueGrey80
import com.example.androidbasictoadvanced.ui.theme.Brown80
import com.example.androidbasictoadvanced.ui.theme.Indigo40
import com.example.androidbasictoadvanced.ui.theme.Indigo80


data class ImageItem(
    val image: Int
)

val imageList = listOf(
    ImageItem(R.drawable.img_discount),
    ImageItem(R.drawable.img_discount2),
    ImageItem(R.drawable.img_discount3),
    ImageItem(R.drawable.img_discount4),
    ImageItem(R.drawable.img_discount5),
    ImageItem(R.drawable.img_discount6),
    ImageItem(R.drawable.img_discount7),
    ImageItem(R.drawable.img_discount8),
    ImageItem(R.drawable.img_discount9),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWingBank() {

    val image = imageList

    Scaffold(

        containerColor = Color(0xFFF0F0F0),

        topBar = {
            TopAppBar(


                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFB7D10D)),

                title = {
                    Text(
                        text = "Wing Bank",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .size(40.dp)
                            .background(Color.Red)
                    ) {
                        Icon(
                                painter = painterResource(R.drawable.ic_coin),
                                contentDescription = "Coin",
                                tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .size(40.dp)
                            .background(Color.Red)
                    ) {
                            Icon(
                            painter = painterResource(R.drawable.ic_qr_code),
                            contentDescription = "QR Code",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    BadgedBox(
                        badge = {
                            Badge (
                                modifier = Modifier
                                    .size(8.dp),
                                containerColor = Color.White
                            ){
                                Text(
                                    text = "",
                                    fontSize = 10.sp
                                )
                            }

                        }
                    ){
                        IconButton(
                            onClick = {},

                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .size(40.dp)
                                .background(Color.Red)

                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = "Notifications",
                                tint = Color.White
                            )
                        }
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
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Home",
                            fontSize = 12.sp
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_favorite),
                                contentDescription = "Favorite",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Favorite",
                            fontSize = 12.sp
                        )
                    }
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .background(Color.Blue, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_qr_scanner),
                                    contentDescription = "QR Code",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BadgedBox(
                            badge = {
                                Badge (
                                ){
                                    Text(
                                        text = "99+",
                                        fontSize = 10.sp
                                    )
                                }

                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Column() {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_chat),
                                        contentDescription = "Chat",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        }
                        Text(
                            text = "Chats",
                            fontSize = 12.sp
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_card),
                                contentDescription = "Card",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Card",
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

    ) {innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Function()
            LazyRow(
                modifier = Modifier.height(150.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(image) { image ->
                    Feature(image)
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Promotion()

            Spacer(modifier = Modifier.height(8.dp))

            News()

        }
    }

}
@Composable
fun Function() {
    Box(

    ) {
        Column(

            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(300.dp)
                //.clip(shape = RoundedCornerShape(16.dp))
                .background(
                    Color.White,
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp)
                    ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_acc_wallet),
                            contentDescription = "account",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }

                    Text(
                        text = "My account",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_transfer),
                            contentDescription = "local transfer",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }

                    Text(
                        text = "Local Transfer" ,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_global),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }
                    Text(
                        text = "World Transfer",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_payment),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }

                    Text(
                        text = "Bill Payment",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_mobile),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }
                    Text(
                        text = "Phone Top Up",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_code),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }
                    Text(
                        text = "Code To Wing",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_saving),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }
                    Text(
                        text = "New Account",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_loans),
                            contentDescription = "Card",
                            modifier = Modifier.size(40.dp),
                            tint = Color(0xFF3949AB)
                        )
                    }
                    Text(
                        text = "Loan",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BadgedBox(
                        badge = {
                            Badge (

                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(
                                        color = Color.Red
                                    ),
                                containerColor = Color.Red,
                                contentColor = Color.White

                            ){
                                Text(
                                    text = "NEW",
                                    fontSize = 10.sp
                                )
                            }

                        }
                    ){
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_card),
                                contentDescription = "Card",
                                modifier = Modifier.size(40.dp),
                                tint = Color(0xFF3949AB)
                            )
                        }
                    }

                    Text(
                        text = "Free Cash Out",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }
}

@Composable
fun Feature(imageItem: ImageItem) {

    Box(
        modifier = Modifier
            .padding(start = 16.dp)
            .width(100.dp)
            .height(200.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 8.dp,
                    bottomEnd = 32.dp
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(imageItem.image),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun Promotion() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Promotions",
            fontWeight = FontWeight.Bold
        )

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Show all",
                color = Indigo40,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.ic_forward_arrow),
                contentDescription = null,
                tint = Color(0xFF3949AB)
            )
        }
    }
}

@Composable
fun News() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(R.drawable.wing_promotion),
            contentDescription = "Promotions",
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
@Preview(showBackground = true)
fun ScreenWingBankPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenWingBank()
    }
}