package com.example.androidbasictoadvanced.feature.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Redo
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.TextFormat
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarScreen6(onBack: () -> Unit) {

    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val scrollBehaviorTop = TopAppBarDefaults.enterAlwaysScrollBehavior()

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

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(vertical = 24.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                FloatingToolbar()
            }

        }
    }

}


@Composable
fun FloatingToolbar() {

    var offsetX by remember { mutableFloatStateOf(0f) } // move left or right
    var offsetY by remember { mutableFloatStateOf(0f) } // move up or down

    var isClicked by remember { mutableStateOf(false) }

    val icons = listOf(
        Icons.AutoMirrored.Filled.Undo,
        Icons.AutoMirrored.Filled.Redo,
        Icons.Filled.Add,
        Icons.Filled.TextFormat,
        Icons.Filled.MoreVert
    )

    val tooltips = listOf(
        "Undo the last action",
        "Redo the last undone action",
        "Add a new item",
        "Format the selected text",
        "More options"
    )

    val scope = rememberCoroutineScope ()

    Column(
        modifier = Modifier
            .offset {
                IntOffset(offsetX.roundToInt(), offsetY.roundToInt())
                // roundToInt Convert Float to Int. Because IntOffset required Int type.
            }
            .pointerInput(Unit) {
                /*
                    pointerInput: This allows the composable to receive touch or mouse input.
                    Without it, the Column cannot detect dragging.
                 */
                detectDragGestures { change, dragAmount ->
                    // This detects when the user drags the toolbar.
                    change.consume()

                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
            .width(80.dp)
            .height(320.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(40.dp)
            )
            .clip(RoundedCornerShape(40.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        icons.forEachIndexed { index, icon ->
            val tooltipState = rememberTooltipState(
                initialIsVisible = false
            )

            TooltipBox(
                positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
                    positioning = TooltipAnchorPosition.Above,
                    spacingBetweenTooltipAndAnchor = 4.dp
                ),
                tooltip = {
                    RichTooltip(
                        title = {
                            Text(tooltips[index])
                        }
                    ) { }
                },

                state = tooltipState

            ) {
                IconButton(
                    onClick = {
                        isClicked = !isClicked

                        scope.launch {
                            tooltipState.show()
                        }
                    }
                )
                {
                    Icon(
                        imageVector = icon, contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ToolbarScreen6Preview() {
    AndroidBasicToAdvancedTheme {
        ToolbarScreen6 {  }
    }
}