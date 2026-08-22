package com.example.androidbasictoadvanced.practice.screenUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Red40
import kotlinx.coroutines.launch


data class ItemModel(
    val title: String
)

val itemList = listOf(
    ItemModel("All"),
    ItemModel("Pizza"),
    ItemModel("Burger"),
    ItemModel("Pasta"),
    ItemModel("Sushi"),
    ItemModel("Salad"),
    ItemModel("Sandwich"),
    ItemModel("Steak"),
    ItemModel("Noodles"),
    ItemModel("Dessert"),
    ItemModel("Drinks")
)

data class Carousel(
    val title: String,
    val img: Int,
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

data class PromotionFood(
    val img: Int
)

val promotionList = listOf(
    PromotionFood(R.drawable.img_pizza_promotion),
    PromotionFood(R.drawable.img_burger_promotion),
    PromotionFood(R.drawable.img_sushi_promotion),
    PromotionFood(R.drawable.img_chicken_promotion),
    PromotionFood(R.drawable.img_sandwitch_promotion),
)

data class MenuItem(
    val icon: Int,
    val label: String,
    val badge: String? = null
)

val menuList = listOf(
    MenuItem(
        R.drawable.ic_home1,
        "Home",
    ),
    MenuItem(
        R.drawable.ic_task,
        "Task",
        "12"
    ),
    MenuItem(
        R.drawable.ic_activity,
        "Activity",
    ),
    MenuItem(
        R.drawable.ic_users,
        "Users",
    ),
    MenuItem(
        R.drawable.ic_notification,
        "Notification",
        "20"
    ),
    MenuItem(
        R.drawable.ic_setting,
        "Setting",
    ),
    MenuItem(
        R.drawable.ic_info,
        "Support",
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenOrderFood(
    onBack: () -> Unit
) {

    var selectedCategory by remember {
        mutableStateOf("All")
    }

//    val item = itemList

    val promotion = promotionList

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val menu = menuList

    val scope = rememberCoroutineScope ()



    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF2B2B2B)
            ) {

                Column(

                    modifier = Modifier
                        .verticalScroll(rememberScrollState())

                ) {

                    Column(

                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_my_picture),
                            contentDescription = "My picture",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Yob Fillin",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "fillinyob@gmail.com",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.5f),

                            )
                    }

                    NavigationDrawerItem(

                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White.copy(alpha = 0.5f)),

                        icon = {

                            Icon(
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = "Search",
                                tint = Color.White
                            )

                        },

                        label = {
                            Text(
                                text = "Search...",
                                color = Color.White
                            )
                        },

                        onClick = {},

                        selected = false
                    )

                    for (item in menu) {
                        NavigationDrawerItem(

                            modifier = Modifier
                                .padding(8.dp),

                            icon = {

                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = "Search",
                                    tint = Color.White
                                )

                            },

                            label = {
                                Text(
                                    text = item.label,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            },

                            badge = if (item.badge?.isNotEmpty() ?: false) {
                                {
                                    Text(
                                        text = item.badge,
                                        fontSize = 12.sp,
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(Red40)
                                            .padding(horizontal = 10.dp)
                                    )
                                }
                            } else null,

                            onClick = {},

                            selected = true,

                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Color.White.copy(alpha = 0.2f),


                            ),

                            shape = RoundedCornerShape(16.dp)

                        )

                    }

                    Row(

                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White.copy(alpha = 0.2f)),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        TextButton(
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "Logout",
                                color = Color.White
                            )
                        }
                    }


                }

            }

        }

    ) {

        Scaffold(

            containerColor = Color(0xFFF0F0F0),

            topBar = {
                LargeTopAppBar(
                    title = {
                        Text(
                            text = buildAnnotatedString {
                                append("Choose\nYour Favorite ")

                                withStyle(
                                    SpanStyle(
                                        color = Color(0xFF87210B),
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("Food")
                                }
                            }
                        )
                    },
                    navigationIcon = {

                        Row(

                            modifier = Modifier.clickable {
                                scope.launch {
                                    drawerState.open()
                                }
                            }

                        ) {

                            IconButton(
                                onClick = onBack
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_arrow_back),
                                    contentDescription = "Back"
                                )
                            }

                            Image(
                                painter = painterResource(R.drawable.img_my_picture),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .size(55.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }

                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFF0F0F0),
                    )
                )
            },

            bottomBar = {
                Surface(
                    shape = RoundedCornerShape(64.dp),
                    tonalElevation = 8.dp,
                    color = Color(0xFF87210B),
                    modifier = Modifier
                        .height(80.dp)
                        .padding(bottom = 16.dp)
                        .padding(horizontal = 16.dp),
                ){

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_home1),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_favorite),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_shop),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }


                }
            }

        ) {paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {


                SearchFood()
                LazyRow {
                    items(itemList) { item ->
                        ItemFood(
                            itemModel = item,
                            isSelected = selectedCategory == item.title,
                            onClick = {
                                selectedCategory = item.title
                            }
                        )
                    }
                }
                PopularFoodText()
                PopularFoodImage()
                PromotionFoodText()

                LazyRow(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(promotion) { item ->
                        PromotionFoodImage(item)
                    }
                }

            }
        }
    }


}

@Composable
fun SearchFood() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp
                )
                .size(height = 60.dp, width = 280.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(
                    color = Color.White,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color.Black.copy(alpha = 0.5f)
                )
            }

            Text(
                text = "Search Food...",
                color = Color.Black.copy(alpha = 0.5f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 16.dp)
                .size(64.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color(0xFF87210B))
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
fun ItemFood(
    itemModel: ItemModel,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(
                top = 16.dp,
                start = 16.dp
            )
            .size(
                width = 80.dp,
                height = 40.dp
            )
            .clip(RoundedCornerShape(32.dp))
            .background(
                if (isSelected) Color(0xFF87210B)
                else Color.White
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = itemModel.title,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}

@Composable
fun PopularFoodText() {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Popular Food",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "See All",
                color = Color(0xFF87210B)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularFoodImage() {

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { foodItems.size },
        preferredItemWidth = 186.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        itemSpacing = 8.dp,
        flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(
            state = rememberCarouselState { foodItems.size }
        ),
        userScrollEnabled = true,
        minSmallItemWidth = CarouselDefaults.MinSmallItemSize,
        maxSmallItemWidth = CarouselDefaults.MaxSmallItemSize,
        contentPadding = PaddingValues(horizontal = 16.dp)

    ) { index ->
        val item = foodItems[index]

        Box{
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
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 6.dp, start = 10.dp)
                    .align(Alignment.BottomCenter)
            )

            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 128.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }


    }

}
@Composable
fun PromotionFoodText() {
    Row(

        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)

    ) {
        Text(
            text = "Promotion Food",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "See All",
            color = Color(0xFF87210B)
        )
    }
}

@Composable
fun PromotionFoodImage(promotionFood: PromotionFood) {

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Image(
            modifier = Modifier
                .height(150.dp)
                .clip(RoundedCornerShape(24.dp)),
            painter = painterResource(promotionFood.img),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenOrderFoodPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenOrderFood {}
    }
}