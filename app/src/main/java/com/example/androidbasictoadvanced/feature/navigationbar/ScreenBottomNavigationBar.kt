package com.example.androidbasictoadvanced.feature.navigationbar

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomNavigationBar(
    onBack: () -> Unit
) {

    var selectedIndex by remember  { mutableIntStateOf(0) }

    val tabItems = listOf(
        NavigationItem(
            icon = R.drawable.ic_home1,
            enabled = true,
            label = "Home",
        ),

        NavigationItem(
            icon = R.drawable.ic_favorite,
            enabled = true,
            label = "Favorite",
        ),

        NavigationItem(
            icon = R.drawable.ic_setting,
            enabled = true,
            label = "Setting",
        ),

    )

        Scaffold(

            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Navigation Bar"
                        )
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        titleContentColor = Color.Black
                    ),

                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_arrow_back),
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }
                    },
                )
            },

            bottomBar = {
                NavigationBar(

//                containerColor = MaterialTheme.colorScheme.onPrimaryFixed

                ) {

                    tabItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == selectedIndex,

                            onClick = {
                                selectedIndex = index
                            },

                            alwaysShowLabel = true,

                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = "Home",
                                )
                            },

                            label = {
                                Text(
                                    text = item.label,
                                )
                            },

                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                selectedTextColor = Color.Black,
                                unselectedIconColor = Color.Black,
                                unselectedTextColor = Color.Black,
                                indicatorColor = Color.Black.copy(alpha = 0.5f)
                            )
                        )
                    }

                }
            }

        ) {paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedContent(
                    targetState = selectedIndex,
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
                        ContentType.HOME.value -> HomeScreen()
                        ContentType.FAVORITE.value -> FavoriteScreen()
                        ContentType.MENU.value -> SettingScreen()
                    }
                }
            }
        }
}



enum class ContentType(val value:Int) {
    HOME(0),
    FAVORITE(1),
    MENU(2),
}

data class NavigationItem(
    @DrawableRes val icon: Int,
    val enabled: Boolean = true,
    val label: String,
    val alwaysShowLabel: Boolean = true,
)

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenBottomNavigationBarPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenBottomNavigationBar {}
    }
}