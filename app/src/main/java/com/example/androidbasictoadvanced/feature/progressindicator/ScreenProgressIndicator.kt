package com.example.androidbasictoadvanced.feature.progressindicator

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ScreenProgressIndicator(
    onBack: () -> Unit
) {

    val currentProgress = remember { mutableFloatStateOf(0f) }

    val scope = rememberCoroutineScope()

    var showCircular by remember { mutableStateOf(false) }

    Scaffold(

        modifier = Modifier.navigationBarsPadding(),

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Progress Indicator"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null,
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),
            )
        },

        bottomBar = {
            Column(

            ) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    onClick = {

                        showCircular = true

//                        scope.launch {
//                            delay(6000)
//                            showCircular = false
//                        }

                    },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA47EDD),
                        contentColor = Color(0xFF34195D)
                    )
                ) {
                    Text(
                        text = "Circular progress indicator"
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    onClick = {
                        scope.launch {
                            loadProgress { value ->
                                currentProgress.floatValue = value
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA47EDD),
                        contentColor = Color(0xFF34195D)
                    )
                ) {
                    Text(
                        text = "Linear progress indicator"
                    )
                }
            }
        }



    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier.height(8.dp),

                color = Color(0xFF15FF00),

                trackColor = Color(0xFF15FF00).copy(alpha = 0.5f),

                progress = {currentProgress.floatValue}
            )
            Text(
                text = "${currentProgress.floatValue*100}%"
            )

            Spacer(modifier = Modifier.height(32.dp))

        }

        if (showCircular) {
            BasicAlertDialog(
                onDismissRequest = {

                    showCircular = false

                },

                properties = DialogProperties(
                    dismissOnBackPress = true,

                    dismissOnClickOutside = false
                )

                ) {

                Box(

                    modifier = Modifier
                        .size(256.dp),
                    contentAlignment = Alignment.Center

                ) {

                    Column(

                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        val transition = rememberInfiniteTransition()

                        val progress by transition.animateFloat(
                            initialValue = 0f,
                            targetValue = 1f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(durationMillis = 1000)
                            )
                        )

                        CircularProgressIndicator(
                            strokeWidth = 8.dp,
                            color = Color(0xFF15FF00),
                            trackColor = Color(0xFF15FF00).copy(alpha = 0.5f),
//                gapSize = 32.dp,
                            modifier = Modifier.size(64.dp),

                            progress = {progress}
                        )

                        LoadingIndicator(
                            color = Color(0xFF15FF00),
                            progress = {progress}
                        )

                        ContainedLoadingIndicator(
                            containerColor = Color(0xFF15FF00).copy(alpha = 0.5f),
                            indicatorColor = Color(0xFF15FF00),

                            progress = {progress}
                        )

                        CircularWavyProgressIndicator(

                            color = Color(0xFF15FF00),
                            trackColor = Color(0xFF15FF00).copy(alpha = 0.5f),

                            progress = {progress}

                        )

                        LinearWavyProgressIndicator(
                            color = Color(0xFF15FF00),
                            trackColor = Color(0xFF15FF00).copy(alpha = 0.5f),

                            progress = {progress}
                        )
                    }

                }


            }
        }



    }

}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}



@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenProgressIndicatorPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenProgressIndicator {}
    }
}