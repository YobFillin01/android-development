package com.example.androidbasictoadvanced.feature.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.launch
import kotlin.collections.forEach
import kotlin.collections.listOf

data class BottomBarItem(
    val tooltip: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

val bottomBarItemLists = listOf(
    BottomBarItem(
        tooltip = "Menu",
        icon = Icons.Filled.Menu,
        onClick = {
            // Menu action
        }
    ),
    BottomBarItem(
        tooltip = "Search",
        icon = Icons.Filled.Search,
        onClick = {
            // Search action
        }
    ),
    BottomBarItem(
        tooltip = "Settings",
        icon = Icons.Filled.Settings,
        onClick = {
            // Settings action
        }
    ),
    BottomBarItem(
        tooltip = "Profile",
        icon = Icons.Filled.Person,
        onClick = {
            // Profile action
        }
    )
)

@Composable
fun ScreenTooltip(onBack:() -> Unit) {

    val bottomBarItems = bottomBarItemLists

    val tooltipState = rememberTooltipState(
        initialIsVisible = false
    )

    val scope = rememberCoroutineScope()

    val plainTooltipText = "Menu"

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
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "More vert",
                            tint = Color(0xFF34195D)
                        )
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFA47EDD),
                contentColor = Color(0xFF34195D)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    bottomBarItems.forEach { item ->

                        TooltipIcon(
                            tooltipText = item.tooltip,
                            icon = item.icon,
                            onClick = item.onClick
                        )

                    }
                }

            }
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }

}

@Composable
fun TooltipIcon(
    tooltipText: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    val tooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()

    TooltipBox(
        positionProvider = TooltipDefaults.rememberTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text(text = tooltipText)
            }
        },
        state = tooltipState
    ) {
        IconButton(
            onClick = {
                onClick()

                scope.launch {
                    tooltipState.show()
                }
            }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = icon,
                contentDescription = tooltipText
            )
        }
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenTooltipPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenTooltip {  }
    }
}