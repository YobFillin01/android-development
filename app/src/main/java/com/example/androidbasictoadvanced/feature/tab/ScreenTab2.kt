package com.example.androidbasictoadvanced.feature.tab

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTab2(
    onBack: () -> Unit
) {

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = tabsList

    val scope = rememberCoroutineScope  ()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Scaffold(

        topBar = {
            TopAppBar(

                modifier = Modifier
                    .padding(horizontal = 16.dp),

                title = {

                    Column(

                        modifier = Modifier
                            .padding(horizontal = 16.dp)

                    ) {
                        Text(
                            text = "Hello Fillin",
                            fontSize = 16.sp,
                            color = Color.Black.copy(alpha = 0.8f)
                        )

                        Text(
                            text = "Welcome Back!",
                            fontWeight = FontWeight.Bold
                        )
                    }

                },

                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.img_my_picture),
                        contentDescription = "My Picture",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                },

                actions = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .width(64.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Gray,   // Choose any color you want
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notifications",
                            tint = Color(0xFF5242FF),
                            modifier = Modifier
                                .size(30.dp)
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

            TabRow(
                selectedTabIndex = selectedTabIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        height = 4.dp,
                        color = Color(0xFF5242FF)
                    )
                }
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
                                contentDescription = "Home"
                            )
                        },
                        enabled = true,

                        selectedContentColor = Color(0xFF5242FF),

                        unselectedContentColor = Color.Gray,

                        text = {Text(text = tabs.label)},

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
                    ContentTypes.HOME.value -> HomeScreen(
                        onBack = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )

                    ContentTypes.QR.value -> HomeOpenQRCode()
                    ContentTypes.PROFILE.value -> HomeTransaction()
                }
            }
        }
    }
}

enum class ContentTypes(val value:Int) {
    HOME(0),
    QR(1),
    PROFILE(2),
}

data class TabModel(
    val icon: Int,
    val label: String
)

val tabsList = listOf(
    TabModel(R.drawable.ic_home1, "Home"),
    TabModel(R.drawable.ic_qr_scanner, "Open QR Code"),
    TabModel(R.drawable.ic_transaction, "Transaction"),
)

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenTab2Preview() {
    AndroidBasicToAdvancedTheme {
        ScreenTab2 {  }
    }
}