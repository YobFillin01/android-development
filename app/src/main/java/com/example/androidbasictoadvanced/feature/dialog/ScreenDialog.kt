package com.example.androidbasictoadvanced.feature.dialog

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDialog(
    onBack: () -> Unit
) {

    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }

    fun onActionDialog(message: String) {
        showDialog = false
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    Scaffold(

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                title = {
                    Text(
                        text = "Dialog"
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
        }



    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    showDialog = true
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA47EDD),
                    contentColor = Color(0xFF34195D)
                )
            ) {
                Text(
                    text = "Click here to open dialog"
                )
            }

        }

        if (showDialog) {

            AlertDialog(

            icon = {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.ic_info),
                    contentDescription = null,
//                    tint = Color.Blue
                )
            },

                title = {
                    Text(
                        text = "Message"
                    )
                },

                text = {
                    Text("Are you want to exit without saving?")
                },

                onDismissRequest = {

                    showDialog = false

                },

                confirmButton = {
                    TextButton(
                        onClick = {
                            onActionDialog("You click confirm button")
                        }
                    ) {
                        Text(
                            text = "Confirm"
                        )
                    }
                },

                dismissButton = {

                    FilledTonalButton(
                        onClick = {
                            onActionDialog("You click dismissButton button")
                        }
                    ) {
                        Text(
                            text = "Dismiss"
                        )
                    }

                },

                shape = RoundedCornerShape(8.dp),

                containerColor = MaterialTheme.colorScheme.primaryContainer,

                textContentColor = MaterialTheme.colorScheme.onBackground,

                titleContentColor = MaterialTheme.colorScheme.onBackground,

                iconContentColor = MaterialTheme.colorScheme.error,

                tonalElevation = 64.dp

            )
        }

    }

}


@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenDialogPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenDialog { }
    }
}