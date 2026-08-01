package com.example.androidbasictoadvanced.feature.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBar(
    onBack: () -> Unit
) {

    val scope = rememberCoroutineScope ()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(

        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Snack Bar",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
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
                    IconButton(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = "This is a warning notification message",
                                    withDismissAction = true,
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_warning),
                            contentDescription = "Email"
                        )
                    }

                    IconButton(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = "This is a info notification message",
                                    withDismissAction = true,
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_info),
                            contentDescription = "Email",
                        )
                    }

                    IconButton(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = "Download successfully",
                                    withDismissAction = true,
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_download_done),
                            contentDescription = "Email"
                        )
                    }
                }
            }
        },

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) { }
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenSnackBarPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenSnackBar {  }
    }
}