package com.example.androidbasictoadvanced.practice.screenUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.practice.NameModel
import com.example.androidbasictoadvanced.practice.User
import com.example.androidbasictoadvanced.practice.names
import com.example.androidbasictoadvanced.practice.users
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSpacerDemo(
    onBack:() -> Unit
) {

    val nameList = names
    val userList = users

    Scaffold(

        topBar = {
            TopAppBar(

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },

                title = {
                    Text(
                        text = "messenger",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },

                actions = {

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_note),
                            contentDescription = "add",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Image(
                        painter = painterResource(R.drawable.img_fb),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(24.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF000000)
                ),

            )
        },

        bottomBar = {

            BottomAppBar(
                containerColor = Color.Black
            ) {



                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                    ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BadgedBox(
                            badge = {

                                Badge {
                                    Text(
                                        text = "+99",
                                        fontSize = 12.sp
                                    )
                                }

                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_chat),
                                    contentDescription = "Chat",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Text(
                            text = "Chats",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        BadgedBox(
                            badge = {
                                Badge (
                                    modifier = Modifier.size(10.dp)
                                ) {
                                    Text(
                                        text = ""
                                    )
                                }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_web_stories),
                                    contentDescription = "Stories",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }


                        Text(
                            text = "Stories",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = "Notifications",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Text(
                            text = "Notifications",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        BadgedBox(
                            badge = {
                                Badge (
                                    modifier = Modifier.size(10.dp)
                                ){
                                    Text(
                                        text = ""
                                    )
                                }
                            }
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_menu),
                                    contentDescription = "Menu",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }


                        Text(
                            text = "Menu",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                }
            }
        },

        containerColor = Color.Black

    ) {innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {

            ScreenSearch()

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.height(120.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(nameList) { name ->
                    ScreenChat(name)
                }

            }
//            Spacer(modifier = Modifier.height(16.dp))
            Info()
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(userList) {user ->
                    UserList(user)
                }

            }


        }

    }

}

@Composable
fun Info () {


    Row(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFF16589C))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "All",
                color = Color(0xFF2226BD),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .height(32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color.DarkGray)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Unread",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .height(32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color.DarkGray)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Groups",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .height(32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color.DarkGray)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "...",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun UserList(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(64.dp))
                .background(color = Color.DarkGray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = user.username,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = user.message,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = user.day,
                    color = Color.Gray
                )
            }
        }

    }
}

@Composable
fun ScreenSearch() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.DarkGray,

                )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "Search",
            color = Color.DarkGray,
            fontSize = 24.sp
        )
    }
}

@Composable
fun ScreenChat(nameModel: NameModel) {

//    Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = "android",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(64.dp))
                    .background(color = Color.DarkGray)
            )

            Text(
                text = nameModel.name,
                color = Color.White,
            )
        }
}

@Composable
@Preview(showBackground = true)
fun ScreenMessengerPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenSpacerDemo {

        }
    }
}