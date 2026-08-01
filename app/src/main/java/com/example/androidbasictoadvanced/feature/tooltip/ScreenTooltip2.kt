package com.example.androidbasictoadvanced.feature.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun ScreenTooltip2(onBack:() -> Unit) {

    var isClicked by remember { mutableStateOf(false) }

    Scaffold(

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                title = {
                    Text(
                        text = "Tooltip",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color(0xFF34195D)
                        )
                    }
                }
            )
        },

    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            IconButton(
                onClick = {

                    isClicked = !isClicked


                }
            ) {
                Icon(
                    imageVector =
                        if (isClicked)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                    contentDescription = "Add to favorites",
                    tint = if (isClicked) Color.Red else Color.Black
                )
            }

        }
    }

}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenTooltip2Preview() {
    AndroidBasicToAdvancedTheme() {
        ScreenTooltip2 {  }
    }
}