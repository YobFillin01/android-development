package com.example.androidbasictoadvanced.feature.toolbar

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatColorFill
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material.icons.filled.FormatUnderlined
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarScreen3(onBack: () -> Unit) {

    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val scrollBehaviorTop = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val icons =
        listOf(
            Icons.Filled.FormatBold,
            Icons.Filled.FormatItalic,
            Icons.Filled.FormatUnderlined,
            Icons.Filled.FormatColorFill,
        )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(

        modifier = Modifier
            .navigationBarsPadding()
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
                            tint = Color(0xFF34195D),
                        )
                    }
                }
            )
        },


        bottomBar = {

            FlexibleBottomAppBar(

                modifier = Modifier
                    .height(110.dp)
                    .padding(horizontal = 64.dp, vertical = 16.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(64.dp)
                    ),
//                    .clip(RoundedCornerShape(64.dp)),
                containerColor = Color(0xFFA47EDD),
                contentColor = Color(0xFF34195D),
                scrollBehavior = scrollBehavior,
                horizontalArrangement = Arrangement.SpaceBetween,
                windowInsets = BottomAppBarDefaults.windowInsets

            ) {
                icons.forEachIndexed { index, icon ->

                    val offsetX by animateDpAsState(
                        targetValue = if (selectedIndex == index) 8.dp else 0.dp,
                        label = "iconOffset"
                    )

                    IconButton(

                        modifier = Modifier
                            .size(45.dp)
                            .offset { IntOffset(offsetX.roundToPx(), 0) },

                        onClick = {
                            selectedIndex = index
                        },

                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = if (selectedIndex == index) {
                                Color.White
                            } else {
                                Color(0xFFA47EDD)
                            },

                            contentColor = if (selectedIndex == index) {
                                Color.Black
                            } else {
                                Color(0xFF34195D)
                            }
                        )

                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .padding(horizontal = 8.dp)
                )
                HorizontalDivider()
            }
        }
    }

}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ToolbarScreen3Preview() {
    AndroidBasicToAdvancedTheme {
        ToolbarScreen3 {  }
    }
}