package com.example.androidbasictoadvanced.feature.lazyRow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


data class MovieItem(
    val rate: String,
    val image: Int
)

val itemList = listOf(
    MovieItem("Rate: 5/10", R.drawable.img_burger1),
    MovieItem("Rate: 9/10", R.drawable.img_sushi),
    MovieItem("Rate: 8/10", R.drawable.img_pasta1),
    MovieItem("Rate: 6/10", R.drawable.img_fried_chicken),
    MovieItem("Rate: 5.5/10", R.drawable.img_pizza1),
    MovieItem("Rate: 8/10", R.drawable.img_noodles1),
    MovieItem("Rate: 6/10", R.drawable.img_snacks),
    MovieItem("Rate: 3/10", R.drawable.img_salad1),
    MovieItem("Rate: 9/10", R.drawable.img_vegetables2),
    MovieItem("Rate: 9.5/10", R.drawable.img_tacos1),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyRow(
    onBack: () -> Unit
) {

    val items = itemList

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "more vert",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                title = {
                    Text(
                        text = "Popular Foods"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFA47EDD),
                contentColor = Color(0xFF34195D)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Menu",
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add),
                            contentDescription = "Add",
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = "Home",
                        )
                    }


                }
            }
        }

    ) { innerPadding ->
        LazyRow(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            items(items) { item ->
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .size(height = 256.dp, width = 150.dp)
                ) {

                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )

                }
            }

        }

    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenLazyRowPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenLazyRow {}
    }
}