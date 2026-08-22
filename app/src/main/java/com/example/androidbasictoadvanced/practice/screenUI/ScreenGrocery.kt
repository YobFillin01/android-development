package com.example.androidbasictoadvanced.practice.screenUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import com.example.androidbasictoadvanced.ui.theme.Green40

data class ImageModel(
    val img: Int,
    val title: String
)

val imageList1 = listOf(
    ImageModel(R.drawable.img_fruits1, "Fruits"),
    ImageModel(R.drawable.img_vegetables2, "Vegetables"),
    ImageModel(R.drawable.img_dairy, "Dairy"),
    ImageModel(R.drawable.img_snacks, "Snacks"),
)

data class FreshFruit(
    val img1: Int,
    val title: String,
    val price: String,
)

val fruitList = listOf(
    FreshFruit(R.drawable.img_bananas, "Fresh Bananas", "$1.20/kg"),
    FreshFruit(R.drawable.img_apples, "Red Apples", "$2.50/kg"),
    FreshFruit(R.drawable.img_orange, "Sweet Oranges", "$1.80/kg"),
    FreshFruit(R.drawable.img_blueberries, "Blueberry", "$3.20/kg"),
    FreshFruit(R.drawable.img_cherries, "Pineapples", "$2.80/each"),
    FreshFruit(R.drawable.img_strawberries, "Strawberries", "$6.00/box"),
    FreshFruit(R.drawable.img_kiwis, "Kiwis", "$3.80/kg"),
    FreshFruit(R.drawable.img_grapes, "Grape", "$4.50/kg")
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenGrocery(
    onBack: () -> Unit
) {

    val image = imageList1

    val fruit = fruitList

    Scaffold(

        containerColor = Color(0xFFF0F0F0),

        topBar = {
            TopAppBar(

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null,
                        )
                    }
                },

                title = {
                    Column {
                        Text(
                            text = "Hi, Fillin👋",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )

                        Text(
                            text = "What would you like to buy today?",
                            fontSize = 16.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    }
                },

                actions = {


                    BadgedBox(
                        badge = {
                            Badge (
                                containerColor = Green40,
                                contentColor = MaterialTheme.colorScheme.background
                            ) {
                                Text(
                                    text = "3",
                                )
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_shop),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }

                }
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            SearchVegetable()
            ImageHeader()

            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
            )

            LazyRow(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {

                items(image) { image ->
                    Vegetables(image)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            PopularVegetablesText()
            LazyRow(

                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                items (fruit) {fruit ->
                    PopularVegetablesImage(fruit)
                }
            }

        }
    }

}

@Composable
fun PopularVegetablesImage(freshFruit: FreshFruit) {
    Column(

        modifier = Modifier
            .padding(horizontal = 16.dp)

    ) {
        Box(

            modifier = Modifier
                .size(
                    width = 128.dp,
                    height = 180.dp
                )
                .clip(RoundedCornerShape(16.dp))

        ) {
            Image(
                painter = painterResource(freshFruit.img1),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = freshFruit.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp)
        )

        Text(
            text = freshFruit.price,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier
                .padding(start = 5.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green40
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "+ Add",
                color = Color.White,
            )
        }
    }
}

@Composable
fun PopularVegetablesText() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular Products",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "See All",
                fontSize = 18.sp,
                color = Color.Black
            )

            Icon(
                painter = painterResource(R.drawable.ic_forward_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun Vegetables(imageModel: ImageModel) {

    Column(

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .size(
                    height = 128.dp,
                    width = 110.dp
                )
                .clip(RoundedCornerShape(16.dp))

        ) {
            Image(
                painter = painterResource(imageModel.img),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize(),
                contentScale = ContentScale.FillBounds
            )

        }

        Text(
            text = imageModel.title,
            fontWeight = FontWeight.Bold,
            color = Green40,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun SearchVegetable() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .height(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Search for products"
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mic),
                    contentDescription = null
                )
            }


        }
    }
}

@Composable
fun ImageHeader() {
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))

    ) {
        Image(
            painter = painterResource(R.drawable.img_vegetables),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Column(

            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center


        ) {
            Text(
                text = "Fresh & Healthy",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Get 20% Off on all vegetables",
                fontSize = 10.sp,
                color = Color.White
            )

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
            ) {

                Row(

                    modifier = Modifier
                        .size(
                            width = 100.dp,
                            height = 32.dp
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "Shop Now",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_forward_arrow),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .size(10.dp)
                    )
                }

            }


        }

    }
}

@Composable
@Preview(showBackground = true)
fun ScreenGroceryPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenGrocery {}
    }
}
