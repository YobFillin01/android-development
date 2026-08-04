package com.example.androidbasictoadvanced.feature.lazycolumn

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Yellow40
import org.w3c.dom.Text


data class Choices(
    val text: String
)

val textList = listOf(
    Choices("All"),
    Choices("Popular"),
    Choices("Offers"),
    Choices("New"),
    Choices("Healthy"),
)

data class FoodChoice(
    val img: Int,
    val title: String,
    val discount: String,
    val type: String,
    val waiting: String,
    val rate: String,
    val duration: String
)

val foodList = listOf(
    FoodChoice(
        R.drawable.img_pizza1,
        "Pizza",
        "10% OFF",
        "Pizza Italian Cheese",
        "15-20min",
        "4.9(2.3k)",
        "1.4kms"
    ),
    FoodChoice(
        R.drawable.img_burger1,
        "Burger",
        "15% OFF",
        "Double Beef Burger",
        "10-15min",
        "4.8(1.9k)",
        "0.8kms"
    ),
    FoodChoice(
        R.drawable.img_sushi,
        "Sushi",
        "20% OFF",
        "Fresh Salmon Sushi",
        "20-25min",
        "4.9(3.1k)",
        "2.0kms"
    ),
    FoodChoice(
        R.drawable.img_pasta1,
        "Pasta",
        "12% OFF",
        "Creamy Alfredo Pasta",
        "18-22min",
        "4.7(1.5k)",
        "1.2kms"
    ),
    FoodChoice(
        R.drawable.img_fried_chicken,
        "Fried Chicken",
        "25% OFF",
        "Crispy Chicken Bucket",
        "12-18min",
        "4.8(2.7k)",
        "1.7kms"
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyColumn(
    onBack: () -> Unit
) {

    val food = foodList

    val texts = textList

    Scaffold(

        containerColor = Color(0xFFB5B5B5),

        topBar = {
            TopAppBar(

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },

                title = {
                    Text(
                        text = "Nearby Restaurants",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold
                    )
                },

                actions = {
                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_three_dots),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFB5B5B5)
                )
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {

            SearchFood2()
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                items(texts) {item ->
                    MenuText(item)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(

                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                items(food) {item ->
                    ImageFood(item)
                }
            }

        }
    }

}

@Composable
fun ImageFood(foodChoice: FoodChoice) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        Row(

        ) {
            Row(

                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(foodChoice.img),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Column(

                    modifier = Modifier
                        .padding(vertical = 8.dp)

                ) {
                    Row(

                        modifier = Modifier.padding(end = 16.dp)

                    ) {
                        Text(
                            text = foodChoice.title,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "Popular",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = foodChoice.discount
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = foodChoice.type,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Row(

                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_timer),
                            contentDescription = "Timer",
                            modifier = Modifier
                                .size(20.dp),
                            tint = Color.Black.copy(alpha = 0.5f)
                        )

                        Text(
                            text = foodChoice.waiting,
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(20.dp),
                            tint = Yellow40
                        )

                        Text(
                            text = foodChoice.rate,
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            painter = painterResource(R.drawable.ic_near_me),
                            contentDescription = "near me",
                            modifier = Modifier
                                .size(20.dp),
                            tint = Color.Black.copy(alpha = 0.5f)
                        )

                        Text(
                            text = foodChoice.duration,
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun MenuText(choices: Choices) {

    var isClicked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FilledTonalButton(
            onClick = {
                isClicked = !isClicked
            },
            colors = ButtonDefaults.buttonColors(

                containerColor = if (isClicked) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.background,
                contentColor = if (isClicked) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text(
                text = choices.text
            )
        }


    }

}

@Composable
fun SearchFood2() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(

            modifier = Modifier
                .size(
                    width = 330.dp,
                    height = 50.dp
                )
                .padding(start = 8.dp)
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically

        ) {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(start = 8.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black.copy(alpha = 0.5f)
                )
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Search",
                )
            }

            Text(
                text = "Search for restaurants or food",
                color = Color.Black.copy(alpha = 0.5f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))


        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 8.dp)
                .size(50.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Black)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = Color.White
            )
        }

    }

}

@Composable
@Preview(showBackground = true)
fun ScreenLazyColumnPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenLazyColumn {}
    }
}