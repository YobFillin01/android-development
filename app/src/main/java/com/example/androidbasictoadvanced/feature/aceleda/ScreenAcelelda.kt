package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.navigationdrawer.DrawerMenuItem
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Red40
import kotlinx.coroutines.launch


data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
)


@Composable
fun ScreenAceleda(
    onNavigateToQrCode: () -> Unit,
    onBack:() -> Unit
) {

    val drawItem = listOf(
        DrawerMenuItem(label = "Last Name: YOB", icon = R.drawable.ic_users),
        DrawerMenuItem(label = "First Name: FILLIN", icon = R.drawable.ic_users),
        DrawerMenuItem(label = "Mobile No: 069942159", icon = R.drawable.ic_call),
        DrawerMenuItem(label = "Gender: Male", icon = R.drawable.ic_gender),
        DrawerMenuItem(label = "Date of Birth: 01/08/2006", icon = R.drawable.ic_calender),
        DrawerMenuItem(label = "Profession: Student", icon = R.drawable.ic_profession),
        DrawerMenuItem(label = "Expiry Date: 09/05/2034", icon = R.drawable.ic_calender),
        DrawerMenuItem(label = "Nationality: Cambodia", icon = R.drawable.ic_nationality),
        DrawerMenuItem(label = "Address: Phnom Penh", icon = R.drawable.is_location),
    )

    val bottomNavItems = listOf(
        BottomNavItem(
            route = "Home",
            label = "Home",
            icon = R.drawable.ic_home1
        ),
        BottomNavItem(
            route = "Favorite",
            label = "Favorite",
            icon = R.drawable.ic_favorite
        ),
        BottomNavItem(
            route = "Live Chat",
            label = "Live Chat",
            icon = R.drawable.ic_chat
        ),
        BottomNavItem(
            route = "Menu",
            label = "Menu",
            icon = R.drawable.ic_menu
        )
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
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
                            text = "YOB FILLIN",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            text = "fillinyob@gmail.com",
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.5f),

                            )

                        for (item in drawItem) {

                            NavigationDrawerItem(
                                modifier = Modifier
                                    .padding(vertical = 16.dp),
                                label = {
                                    Text(
                                        text = item.label,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                },

                                selected = false,

                                onClick = {

                                    scope.launch { drawerState.close() }

                                },

                                icon = {
                                    Icon(
                                        painter = painterResource(item.icon),
                                        contentDescription = null,
                                        tint = Color.Black
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

            containerColor = Color(0xFF0D3157),

            topBar = {
                TopAppBar(

                    navigationIcon = {
                        IconButton(
                            onClick = {
                                onBack()
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_arrow_back_new),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },

                    title = {
                        Text(
                            text = "អេសុីលីដា",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF0D3157),
                        titleContentColor = Color.White
                    ),


                    actions = {

                        BadgedBox(
                            badge = {
                                Badge(modifier = Modifier.size(8.dp))
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_notification),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }


                        IconButton(
                            onClick = {
                                onNavigateToQrCode()
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_qr_code),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                )
            },

            bottomBar = {
                NavigationBar(
                    containerColor = Color(0xFF0D3157)
                ) {

                    bottomNavItems.forEachIndexed { index, item ->
                        NavigationBarItem(

                            selected = false,

                            onClick = {
                                selectedIndex = index
                                navController.navigate(item.route)
                            },

                            label = {
                                Text(
                                    text = item.label
                                )
                            },

                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = null
                                )
                            },

                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor =
                                    if (selectedIndex == index) Color(0xFFBF9A33)
                                    else Color.White,

                                selectedTextColor =
                                    if (selectedIndex == index) Color(0xFFBF9A33)
                                    else Color.White,

                                unselectedIconColor =
                                    if (selectedIndex == index) Color(0xFFBF9A33)
                                    else Color.White,

                                unselectedTextColor =
                                    if (selectedIndex == index) Color(0xFFBF9A33)
                                    else Color.White,


                            )

                        )
                    }
                }
            }
        ) { paddingValues ->

            NavHost(
                navController = navController,
                startDestination = "Home",
                modifier = Modifier.padding(paddingValues)
            ) {

                composable(
                    route = "Home",
                    enterTransition = {
                        if (initialState.destination.route == "Home") {
                            EnterTransition.None
                        } else {
                            slideInHorizontally(
                                animationSpec = tween(300),
                                initialOffsetX = { -it }
                            ) + fadeIn()
                        }
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenHomeAceleda(
                        onNavigateToPayment = {
                            navController.navigate("Payment")
                        },
                        onNavigateToMobileTopUp = {
                            navController.navigate("TopUp")
                        },
                        onNavigateToCards = {
                            navController.navigate("Card")
                        },
                        onNavigateToQr = {
                            navController.navigate("Qr")
                        },
                        onNavigateToLoan = {
                            navController.navigate("Loan")
                        },
                        onNavigateToDeposit = {
                            navController.navigate("Deposit")
                        },
                        onNavigateToQuickCash = {
                            navController.navigate("Quick Cash")
                        },
                        onNavigateToTransfer = {
                            navController.navigate("Transfer")
                        },
                        onProfileClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }

                composable(
                    route = "Favorite",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    FavoriteScreen()
                }

                composable(
                    route = "Live Chat",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    LiveChatScreen()
                }

                composable(
                    route = "Menu",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    MenuScreen()
                }

                composable(
                    route = "Payment",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenPayment(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "TopUp",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenMobileTopUp(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Card",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenCards(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Qr",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenQr(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Transfer",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenTransfer(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Deposit",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenDeposit(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Loan",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(300)
                        )
                    }
                ) {
                    ScreenLoan(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "Quick Cash",
                    enterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { -it }
                        ) + fadeOut()
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { -it }
                        ) + fadeIn()
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            animationSpec = tween(300),
                            targetOffsetX = { it }
                        ) + fadeOut()
                    }
                ) {
                    ScreenQuickCash(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable ("OpenQrCode") {
                    ScreenOpenQrCode (
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }

        }
    }
}


@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenAceledaPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenAceleda (
            onNavigateToQrCode = {},
            onBack = {}
        )
    }
}