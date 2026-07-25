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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.progressindicator.loadProgress
import com.example.androidbasictoadvanced.ui.theme.Amber40
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

data class TypesOfCoffee(
    val text: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCoffeeShop() {

    val coffeeType = listOf(
        TypesOfCoffee("Hot Coffee"),
        TypesOfCoffee("Iced Coffee"),
        TypesOfCoffee("Espresso"),
        TypesOfCoffee("Americano"),
        TypesOfCoffee("Cappuccino"),
        TypesOfCoffee("Latte"),
        TypesOfCoffee("Mocha"),
        TypesOfCoffee("Macchiato"),
        TypesOfCoffee("Flat White"),
        TypesOfCoffee("Cold Brew"),
        TypesOfCoffee("Affogato")
    )

    Scaffold(

        containerColor = Color.Black,

        topBar = {

            TopAppBar(

                navigationIcon = {
                    Row(

                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_menu),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                },
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.is_location),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Text(
                            text = "Battambang",
                            fontSize = 16.sp
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),

                actions = {
                    val hasNotification = true

                    BadgedBox(
                        badge = {
                            if (hasNotification) {
                                Badge(
                                    modifier = Modifier.size(8.dp)
                                ) {}
                            }
                        }
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            )

        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

            PromotionImage1()

            Spacer(modifier = Modifier.height(16.dp))

            SearchItem()

            Categories()

            LazyRow(
            ) {
                items(coffeeType) { item ->
                    MenuCoffee(item)
                }
            }


        }
    }
}

@Composable
fun PromotionImage1() {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp)

    ) {

        Box(

            modifier = Modifier.fillMaxSize()

        ) {

            Image(
                painter = painterResource(R.drawable.img_background_naatural),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Row(

                modifier = Modifier
                    .padding(top = 24.dp)

            ) {
                Column(

                    modifier = Modifier
                        .padding(start = 16.dp)

                ) {
                    Text(
                        text = "20% OFF On All\nEspresso",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )

                    Text(
                        text = "Today Only Limited Time Offer",
                        color = Color.White,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    FilledTonalButton(
                        onClick = {},

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Amber40
                        )
                    ) {
                        Text(
                            text = "Order Now"
                        )
                    }
                }

                Spacer(modifier = Modifier.width(32.dp))

                Box(

                    modifier = Modifier
                        .size(150.dp)

                ) {
                    Image(
                        painter = painterResource(R.drawable.img_espresso1),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                    )
                }

            }

        }

    }

}

@Composable
fun SearchItem() {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {

        Row(

            modifier = Modifier
                .width(310.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White.copy(alpha = 0.1f)),
            verticalAlignment = Alignment.CenterVertically

        ) {

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }


            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Search Coffee...",
                color = Color.White.copy(alpha = 0.5f),
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mic),
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }

        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Amber40
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_menu),
                contentDescription = null,
                tint = Color.White

            )
        }
    }
}

@Composable
fun Categories() {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Popular Food",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "See All",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.5f)
            )
        }
    }
}

@Composable
fun MenuCoffee(typesOfCoffee: TypesOfCoffee) {

    var isSelected by remember { mutableStateOf(false) }

    Row(

        modifier = Modifier
            .padding(start = 16.dp)

    ) {
        OutlinedButton(

            onClick = {
                isSelected = !isSelected
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelected) Amber40 else Color.Black,
                contentColor = if (isSelected) Color.White else Color.White.copy(alpha = 0.5f)
            )
        ) {
            Text(
                text = typesOfCoffee.text,
                color = Color.White
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenCoffeeShopPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenCoffeeShop()
    }
}