package com.example.androidbasictoadvanced.feature.timepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTimePicker(
    onBack: () -> Unit
) {

    val calender = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = calender.get(Calendar.HOUR_OF_DAY),
        initialMinute = calender.get(Calendar.MINUTE)
    )

    var isShowedTimePicker by remember { mutableStateOf(false) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Time Picker"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back1),
                            contentDescription = null,
                        )
                    }
                }
            )
        },

        bottomBar = {
            Button(
                onClick = {

                    isShowedTimePicker = true

                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA47EDD),
                    contentColor = Color(0xFF34195D)
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            ) {
                Text(
                    text = "Open Time Picker"
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

        }


        if (isShowedTimePicker) {

            TimePickerDialog(
                onDismissRequest = {
                    isShowedTimePicker = false
                },
                confirmButton = {

                    TextButton(
                        onClick = {
                            isShowedTimePicker = false
                        }
                    ) {
                        Text(
                            text = "Confirm"
                        )
                    }

                },

                dismissButton = {

                    FilledTonalButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(
                            text = "Cancel"
                        )
                    }
                },

                title = {
                    Text(
                        text = "Add Alarm",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            ) {
                TimePicker(
                    state = timePickerState,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Black,
                        clockDialSelectedContentColor = Color.Black,
                        clockDialUnselectedContentColor = Color.Cyan,
                        periodSelectorBorderColor = Color.Red,
                        periodSelectorUnselectedContainerColor = Color.Gray,
                        periodSelectorSelectedContentColor = Color.Black,
                        periodSelectorUnselectedContentColor = Color.White,
                        selectorColor = Color.White.copy(alpha = 0.2f),
                        timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.primary,
                        timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimary,
                        timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.secondary,
                        timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSecondary
                    )
                )
            }

        }

    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenTimePickerPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenTimePicker {}
    }
}