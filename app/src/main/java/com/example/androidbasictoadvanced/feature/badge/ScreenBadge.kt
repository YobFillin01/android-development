package com.example.androidbasictoadvanced.feature.badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBadge(
    onBack: () -> Unit
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Headline",
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Subtitle",
                            fontSize = 16.sp,
                        )
                    }
                },

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "Search",
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
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                )
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFA47EDD),
                contentColor = Color(0xFF34195D)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        BadgedBox(
                            badge = {
                                Badge (
                                ){
                                    Text(
                                        text = "99+"
                                    )
                                }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Column() {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_chat),
                                        contentDescription = "Chat",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        }

                        Text(
                            text = "Chats",
                            fontSize = 12.sp
                        )

                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BadgedBox(
                            badge = {
                                Badge (
                                    modifier = Modifier.size(8.dp)
                                ) {  }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_web_stories),
                                    contentDescription = "Story",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Text(
                            text = "Stories",
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text(
                                        text = "54"
                                    )
                                }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_notification),
                                    contentDescription = "notification",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Text(
                            text = "Notifications",
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BadgedBox(
                            badge = {
                                Badge(
                                    modifier = Modifier.size(8.dp)
                                ) {  }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_menu),
                                    contentDescription = "Menu",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                        Text(
                            text = "Menu",
                            fontSize = 12.sp
                        )
                    }
                }

            }
        }

    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenBadgePreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenBadge {}
    }
}