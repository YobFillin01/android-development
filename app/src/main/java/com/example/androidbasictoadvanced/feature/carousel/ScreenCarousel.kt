package com.example.androidbasictoadvanced.feature.carousel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
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
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCarousel(
    onBack: () -> Unit
) {

    data class Carousel(
        val title: String,
        @DrawableRes val img: Int,
        val description: String
    )

    val foodItems = listOf(
        Carousel(" Pizza ", R.drawable.img_pizza1, "Cheesy pizza with fresh toppings"),
        Carousel(" Burger ", R.drawable.img_burger1, "Juicy beef burger with lettuce"),
        Carousel(" Sushi ", R.drawable.img_sushi, "Fresh sushi rolls with salmon"),
        Carousel(" Pasta ", R.drawable.img_pasta1, "Creamy pasta with parmesan cheese"),
        Carousel(" Fried Chicken ", R.drawable.img_fried_chicken, "Crispy fried chicken pieces"),
        Carousel(" Steak ", R.drawable.img_steak, "Grilled steak cooked to perfection"),
        Carousel(" Tacos ", R.drawable.img_tacos1, "Mexican tacos with beef filling"),
        Carousel(" Ice Cream ", R.drawable.img_ice_cream1, "Vanilla ice cream with toppings"),
        Carousel(" Salad ", R.drawable.img_salad1, "Healthy mixed vegetable salad"),
        Carousel(" Noodles ", R.drawable.img_noodles1, "Stir-fried noodles with vegetables")
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Carousel"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back1),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }

    ) {paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
        ) {

            SearchForService()

            HorizontalMultiBrowseCarousel(
                state = rememberCarouselState() { foodItems.size },
                preferredItemWidth = 186.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                itemSpacing = 8.dp,
                flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(
                    state = rememberCarouselState() { foodItems.size }
                ),
                userScrollEnabled = true,
                minSmallItemWidth = CarouselDefaults.MinSmallItemSize,
                maxSmallItemWidth = CarouselDefaults.MaxSmallItemSize,
                contentPadding = PaddingValues(horizontal = 16.dp)

            ) { index ->
                val item = foodItems[index]

                Box(

                ) {
                    Image(
                        modifier = Modifier
                            .height(205.dp)
                            .maskClip(MaterialTheme.shapes.extraLarge), // corner
                        painter = painterResource(item.img),
                        contentDescription = item.description,
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = item.title,
                        color = Color.White,
                        modifier = Modifier
                            .padding(bottom = 16.dp, start = 16.dp)
                            .align(Alignment.BottomStart)
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
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
            .padding(16.dp)
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
            text = "Search for a food...",
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.5f)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenCarouselPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenCarousel {}
    }
}