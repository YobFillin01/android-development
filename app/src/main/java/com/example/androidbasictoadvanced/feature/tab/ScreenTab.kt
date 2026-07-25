package com.example.androidbasictoadvanced.feature.tab

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.navigationdrawer.ContentType
import com.example.androidbasictoadvanced.feature.navigationdrawer.FavoriteScreen
import com.example.androidbasictoadvanced.feature.navigationdrawer.HomeScreen
import com.example.androidbasictoadvanced.feature.navigationdrawer.SettingScreen
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.launch

data class ItemModel(
    val label: String,
    val icon: Int
)

val tabList = listOf(
    ItemModel("Home", R.drawable.ic_home1),
    ItemModel("Favorite", R.drawable.ic_favorite),
    ItemModel("Setting", R.drawable.ic_setting),
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTab(
    onBack:() -> Unit
) {

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = tabList

    val scope = rememberCoroutineScope ()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tab Components",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = Color.Black
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.Black
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
            PrimaryTabRow(

               selectedTabIndex = selectedTabIndex

            ) {

                tabs.forEachIndexed { index, tabs ->

                    Tab(
                        selected = index == selectedTabIndex,

                        onClick = {
                            selectedTabIndex = index
                        },

                        icon = {
                            Icon(
                                painter = painterResource(tabs.icon),
                                contentDescription = "Icon"
                            )
                        },

                        enabled = true,

                        selectedContentColor = Color.Black,

                        unselectedContentColor = Color.Gray,

                        text = {Text(text = tabs.label)}
                    )

                }

            }

            AnimatedContent(
                targetState = selectedTabIndex,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn() togetherWith
                                slideOutHorizontally(
                                    animationSpec = tween(300),
                                    targetOffsetX = { -it }
                                ) + fadeOut()
                    } else {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn() togetherWith
                                slideOutHorizontally(
                                    animationSpec = tween(300),
                                    targetOffsetX = { it }
                                ) + fadeOut()
                    }
                },
                label = "ScreenAnimation"
            ) { screen ->
                when (screen) {
                    ContentType.HOME.value -> HomeScreen(
                        onProfileClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                    ContentType.FAVORITE.value -> FavoriteScreen()
                    ContentType.MENU.value -> SettingScreen()
                }
            }

        }
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenTabPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenTab {  }
    }
}