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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Cyan40
import com.example.androidbasictoadvanced.ui.theme.Cyan80
import com.example.androidbasictoadvanced.ui.theme.Teal40


data class ServiceModel(
    val img: Int,
    val rate: String,
    val review: String,
    val caption:String,
    val price: String,
    val account: String
)

val serviceList = listOf(
    ServiceModel(R.drawable.img_cleaning_service,
        " ⭐3.0",
        "(350 Review)",
        "Home Cleaning",
        "$10 - $20",
        "Jackson "),
    ServiceModel(R.drawable.img_massage,
        " ⭐5.0",
        "(1000 Review)",
        "Body Massage",
        "$20 - $40",
        "Jonh"),
    ServiceModel(R.drawable.img_painting1,
        " ⭐5.0",
        "(700 Review)",
        "Painting",
        "$15 - $50",
        "Smith"),
    ServiceModel(R.drawable.img_nail_salon,
        " ⭐4.5",
        "(400 Review)",
        "Nail Service",
        "$10 - $25",
        "Monika"),
    ServiceModel(R.drawable.img_barber,
        " ⭐3.5",
        "(250 Review)",
        "barber services",
        "$15 - $20",
        "Emily"),
    ServiceModel(R.drawable.img_camera,
        " ⭐5.0",
        "(1200 Review)",
        "Photographer",
        "$100 - $250",
        "Albert")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAppService(
    onBack: () -> Unit
) {

    val service = serviceList

    Scaffold(
        containerColor = Color(0xFFEDEDED),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Location",
                            tint = Cyan40

                        )
                    }
                },
                title = {
                    Column {
                        Text(
                            text = "Your location",
                            fontSize = 12.sp
                        )

                        Row {
                            Text(
                                text = "Phnom Penh",
                                fontWeight = FontWeight.Bold
                            )
                            IconButton(
                                onClick = {},
                                modifier = Modifier
                                    .size(30.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_arrow_bottom),
                                    contentDescription = "Notification"
                                )
                            }

                        }
                    }
                },

                actions = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .background(Color.White)
                            .size(35.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notification"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan80
                )
            )
        }
    ) {innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchForService()
            BoxBar()
            ServiceCategories()
            TitlePopularService()

            LazyRow {
                items(service) { service ->
                    PopularService(service)
                }
            }
        }
    }
}

@Composable
fun SearchForService() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(45.dp)
            .border(
                width = 1.dp,
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(24.dp),
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(start = 16.dp)
                .size(30.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Notification",
                tint = Color.Black.copy(alpha = 0.5f)
            )
        }

        Text(
            text = "Search for a service...",
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun BoxBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 8.dp)
            .clip(
                RoundedCornerShape(16.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Teal40
        )

    ) {
        Row {
            Column {
                Text(
                    text = """
                YOUR SOLUTION,
                ONE TAP AWAY!
            """.trimIndent(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                )
                Text(
                    text = "Seamless Fast & Reliable",
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )
                )
                Text(
                    text = "Service at your Fingertips",
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )

                )

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "Explore",
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(

                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(R.drawable.img_cleanner),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(
                            end = 8.dp
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun ServiceCategories() {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Services Categories",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "View all",
                    fontSize = 16.sp,
                    color = Teal40
                )

                Icon(
                    painter = painterResource(R.drawable.ic_forward_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Teal40
                )
            }


        }

       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 8.dp),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Box(

               modifier = Modifier
                   .size(120.dp)
                   .clip(RoundedCornerShape(32.dp))
                   .background(Color.White)

           ) {
               Column(
                   verticalArrangement = Arrangement.spacedBy(32.dp)
               ) {
                   IconButton(
                       onClick = {}
                   ) {
                       Icon(
                           painter = painterResource(R.drawable.ic_air),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 16.dp),
                           tint = Teal40
                       )
                   }
//                   Spacer(modifier = Modifier.height(24.dp))
                   Text(
                       text = "HairDresser",
                       fontWeight = FontWeight.Bold,
                       fontSize = 15.sp,
                       modifier = Modifier
                           .padding(start = 16.dp)
                   )
               }
           }

           Box(

               modifier = Modifier
                   .size(120.dp)
                   .clip(RoundedCornerShape(32.dp))
                   .background(Color.White)

           ) {
               Column(
                   verticalArrangement = Arrangement.spacedBy(32.dp)
               ) {
                   IconButton(
                       onClick = {}
                   ) {
                       Icon(
                           painter = painterResource(R.drawable.ic_cleaning),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 16.dp),
                           tint = Teal40
                       )
                   }
//                   Spacer(modifier = Modifier.height(24.dp))
                   Text(
                       text = "Cleaning",
                       fontWeight = FontWeight.Bold,
                       fontSize = 15.sp,
                       modifier = Modifier
                           .padding(start = 16.dp)
                   )
               }
           }

           Box(

               modifier = Modifier
                   .size(120.dp)
                   .clip(RoundedCornerShape(32.dp))
                   .background(Color.White)

           ) {
               Column(
                   verticalArrangement = Arrangement.spacedBy(32.dp)
               ) {
                   IconButton(
                       onClick = {}
                   ) {
                       Icon(
                           painter = painterResource(R.drawable.ic_painting),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 16.dp),
                           tint = Teal40
                       )
                   }
//                   Spacer(modifier = Modifier.height(24.dp))
                   Text(
                       text = "Painting",
                       fontWeight = FontWeight.Bold,
                       fontSize = 15.sp,
                       modifier = Modifier
                           .padding(start = 16.dp)
                   )
               }
           }
       }
    }
}

@Composable
fun TitlePopularService() {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular Services",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "View all",
                fontSize = 16.sp,
                color = Teal40
            )

            Icon(
                painter = painterResource(R.drawable.ic_forward_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                tint = Teal40
            )
        }

    }
}

@Composable
fun PopularService(serviceModel: ServiceModel) {
    Column {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)

        ) {
            Box(

                modifier = Modifier
                        .size(
                            width = 300.dp,
                            height = 400.dp
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
            ) {
                Column {
                    Image(
                        painter = painterResource(serviceModel.img),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp)

                    ) {
                        Text(
                            text = serviceModel.rate,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp

                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = serviceModel.review,
                            color = Color.Black.copy(alpha = 0.5f),
                            fontSize = 12.sp
                        )
                    }

                    Text(
                        text = serviceModel.caption,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                    Text(
                        text = serviceModel.price,
                        color = Color.Black.copy(alpha = 0.5f),
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                    HorizontalLine()

                    Row(

                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = null,
                                tint = Teal40
                            )
                        }

                        Text(
                            text = serviceModel.account,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ScreenAppServicePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenAppService {

        }
    }
}