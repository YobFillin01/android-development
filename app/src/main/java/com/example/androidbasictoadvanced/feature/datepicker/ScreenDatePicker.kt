package com.example.androidbasictoadvanced.feature.datepicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
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
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDatePickerDialog(
    onBack: () -> Unit
) {

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
//        initialDisplayMode = DisplayMode.Input,
        initialDisplayMode = DisplayMode.Picker,
    )

    var isShowedDatePicker by remember { mutableStateOf(false) }



    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Date Picker Dialog"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back1),
                            contentDescription = null
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
            Button(
                onClick = {
                    isShowedDatePicker = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA47EDD),
                    contentColor = Color(0xFF34195D)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Select Date"
                )
            }
        }



    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
        if (isShowedDatePicker) {
            DatePickerDialog(
                onDismissRequest = {

                    isShowedDatePicker = false

                },
                dismissButton = {

                    FilledTonalButton(
                        onClick = {
                            isShowedDatePicker = false
                        }
                    ) {
                        Text(
                            text = "Cancel"
                        )
                    }

                },
                confirmButton = {

                    TextButton(
                        onClick = {
                            isShowedDatePicker = false
                            datePickerState.selectedDateMillis?.let {
                                println("==========> Select date: $it")
                            }
                        }
                    ) {
                        Text("Confirm")
                    }

                }
            ) {
                DatePicker(
                    state = datePickerState,
                    showModeToggle = true, // Icon in the right top
                    title = {
                        Text(
                            text = "Select your birthday",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp),
                            textAlign = TextAlign.Center
                        )
                    },

                    dateFormatter = DatePickerDefaults.dateFormatter(
                        selectedDateSkeleton = "MMM dd, yyyy",
                        selectedDateDescriptionSkeleton = "EEEE, MMMM dd, yyyy",
                        yearSelectionSkeleton = "yyyy"
                    )


                )
            }
        }

    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenDatePickerDialogPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenDatePickerDialog {}
    }
}