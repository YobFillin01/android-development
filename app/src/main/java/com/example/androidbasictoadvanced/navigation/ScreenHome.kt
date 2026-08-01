package com.example.androidbasictoadvanced.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun ScreenHome(
    onClickComponent: (Any) -> Unit
) {
    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Master Android",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.img_my_picture),
                        contentDescription = "My picture",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }

    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {
            items (50){
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                onClickComponent(100)
                            }
                        ),
                    text = "Item $it"
                )
            }
        }
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenHomePreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenHome (
            onClickComponent = {}
        )
    }
}

