package com.example.androidbasictoadvanced.feature.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TransferWithinAStation
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarScreen2(onBack: () -> Unit) {

    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val scrollBehaviorTop = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val icons =
        listOf(
            Icons.Filled.Download,
            Icons.Filled.TransferWithinAStation,
            Icons.Filled.Email,
            Icons.Filled.Alarm,
            Icons.Filled.Star,
        )

    Scaffold(

        modifier = Modifier
            .nestedScroll(scrollBehaviorTop.nestedScrollConnection)
            .nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                scrollBehavior = scrollBehaviorTop,

                title = {
                    Text(
                        text = "Toolbar",
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


        bottomBar = {

            FlexibleBottomAppBar(

                containerColor = Color(0xFFA47EDD),
                contentColor = Color(0xFF34195D),
                scrollBehavior = scrollBehavior,
                horizontalArrangement = Arrangement.SpaceBetween,
                windowInsets = BottomAppBarDefaults.windowInsets

            ) {
                icons.forEachIndexed { index, icon ->
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
                }
            }
        }

    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(vertical = 24.dp)
                .fillMaxSize()
        ) {
            items(100) { item ->
                Text(
                    text = "${item+1}. Hello World",
                    modifier = Modifier.fillMaxWidth().height(42.dp).padding(horizontal = 8.dp)
                )
                HorizontalDivider()
            }
        }
    }

}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ToolbarScreen2Preview() {
    AndroidBasicToAdvancedTheme() {
        ToolbarScreen2 {  }
    }
}