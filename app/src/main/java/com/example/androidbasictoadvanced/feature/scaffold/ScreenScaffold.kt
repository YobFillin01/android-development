package com.example.androidbasictoadvanced.feature.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRow(
    onBack: () -> Unit
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Hello Fillin!",
                        color = Color.White,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "arrow back",
                            tint = Color.White,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color.DarkGray
            ) {
//                Text(
//                    text = "This is a bottom bar",
//                    color = Color.White,
//                )

                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = "Home",
                            tint = Color.White,
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Menu",
                            tint = Color.White,
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite),
                            contentDescription = "Favorite",
                            tint = Color.White
                        )
                    }
                }

            }
        }

    ) {innerPadding->

//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.Default.Home,
//                contentDescription = "Home",
//                tint = Color.Blue
//            )
//
//            Spacer(modifier = Modifier.width(8.dp))
//
//            Text(
//                text = "Home",
//                color = Color.Black
//            )
//        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello world",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.purple_500))
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hello world",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.purple_500))
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hello world",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.purple_500))
            )
        }

    }

}

@Composable
@Preview(showBackground = true)
fun ScreenRowPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenRow {}
    }
}