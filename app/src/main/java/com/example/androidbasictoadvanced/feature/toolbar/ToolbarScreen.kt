package com.example.androidbasictoadvanced.feature.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarScreen(onBack: () -> Unit) {

    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val scrollBehaviorTop = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val icons =
        listOf(
            Icons.AutoMirrored.Filled.ArrowBack,
            Icons.AutoMirrored.Filled.ArrowForward,
            Icons.Filled.Add,
            Icons.Filled.Tab,
            Icons.Filled.MoreVert,
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

                    Box(

                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center

                    ) {
                        if (index == icons.size/2) {
                            FilledIconButton (
                                modifier = Modifier.size(50.dp),
                                onClick = {},
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = Color(0xFF34195D),
                                    contentColor = Color.White
                                ),

                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = "Edit"
                                )
                            }
                        } else {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = "Back"
                                )
                            }
                        }
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

//@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
@Preview(showBackground = true)
fun ToolbarScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        ToolbarScreen {  }
    }
}