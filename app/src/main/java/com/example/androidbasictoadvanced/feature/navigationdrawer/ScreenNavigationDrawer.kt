package com.example.androidbasictoadvanced.feature.navigationdrawer

import android.graphics.fonts.Font
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
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
import com.example.androidbasictoadvanced.ui.theme.Red40
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationDrawer(
    onBack: () -> Unit
) {

    var selectedIndex by remember  { mutableIntStateOf(0) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

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

    val drawItem = listOf(
        DrawerMenuItem(
            label = "Home",
            icon = R.drawable.ic_home1,
            badge = "13"
        ),
        DrawerMenuItem(
            label = "Profile",
            icon = R.drawable.ic_profile,
            badge = "2"
        ),
        DrawerMenuItem(
            label = "Setting",
            icon = R.drawable.ic_setting,
            badge = "8"
        ),
        DrawerMenuItem(
            label = "Notifications",
            icon = R.drawable.ic_notification,
            badge = "15"
        ),
        DrawerMenuItem(
            label = "Favorites",
            icon = R.drawable.ic_favorite,
            badge = "5"
        ),
        DrawerMenuItem(
            label = "Users",
            icon = R.drawable.ic_users,
            badge = ""
        ),
        DrawerMenuItem(
            label = "Downloads",
            icon = R.drawable.ic_download,
            badge = "3"
        ),
        DrawerMenuItem(
            label = "Mail",
            icon = R.drawable.ic_mail,
            badge = ""
        ),
        DrawerMenuItem(
            label = "Share",
            icon = R.drawable.ic_share,
            badge = ""
        ),
        DrawerMenuItem(
            label = "About",
            icon = R.drawable.ic_info,
            badge = ""
        ),
        DrawerMenuItem(
            label = "Logout",
            icon = R.drawable.ic_logout,
            badge = ""
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,

        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = Color(0xFF2B2B2B)
            ) {

                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(

                        modifier = Modifier
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

                        for (item in drawItem) {

                            NavigationDrawerItem(
                                modifier = Modifier
                                    .padding(vertical = 16.dp),
                                label = {
                                    Text(
                                        text = item.label,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                },

                                selected = false,

                                onClick = {

                                },

                                icon = {
                                    Icon(
                                        painter = painterResource(item.icon),
                                        contentDescription = null,
                                        tint = Color.White
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
                                } else null
                            )
                            HorizontalDivider()
                        }
                    }

                }
            }
        }
    ) {

        Scaffold(

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

data class DrawerMenuItem(
    val label: String,
    val icon: Int,
    val badge: String? = null
)

@Composable
@Preview(showBackground = true)
fun ScreenNavigationDrawerPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenNavigationDrawer {}
    }
}