package com.example.androidbasictoadvanced.feature.dialog

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreenDialog(
    onBack: () -> Unit
) {

    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }

//    fun onActionDialog(message: String) {
//        showDialog = false
//        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
//        toast.show()
//    }

    Scaffold(

        modifier = Modifier.navigationBarsPadding(),

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                title = {
                    Text(
                        text = "Full Screen Dialog"
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
            )
        },

        bottomBar = {
            Button(
                onClick = {
                    showDialog = true
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA47EDD),
                    contentColor = Color(0xFF34195D)
                )
            ) {
                Text(
                    text = "Open full screen dialog"
                )
            }
        }



    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (showDialog) {

                BasicAlertDialog(
                    onDismissRequest = {

                    },
                    properties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = false,
                        usePlatformDefaultWidth = false
                    )
                ) {
                    Box(

                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)

                    ) {
                        Column(

                        ) {
                            Row(

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically

                            ) {

                                IconButton(
                                    onClick = {
                                        showDialog = false
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_close),
                                        contentDescription = "Close",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(32.dp))

                                Text(
                                    text = "Full-Screen-Dialog"
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                TextButton(
                                    onClick = {
                                        showDialog = false

                                        val toast = Toast.makeText(context, "Data saved", Toast.LENGTH_LONG)
                                        toast.show()
                                    }
                                ) {
                                    Text(
                                        text = "Save"
                                    )
                                }

                            }
                        }
                    }
                }
            }

        }
    }

}


@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun FullScreenDialogPreview() {
    AndroidBasicToAdvancedTheme() {
        FullScreenDialog {}
    }
}