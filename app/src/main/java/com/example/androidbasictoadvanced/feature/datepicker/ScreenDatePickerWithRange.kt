package com.example.androidbasictoadvanced.feature.datepicker



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerDefaults
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
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDatePickerWithRange(
    onBack: () -> Unit
) {

    val dateRangePickerState = rememberDateRangePickerState(
        initialDisplayMode = DisplayMode.Picker
    )

    var isShowedDateRangePicker by remember { mutableStateOf(false) }

    var startDate by remember { mutableStateOf<Long?>(null) }
    var endDate by remember { mutableStateOf<Long?>(null) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Date Picker With Range"
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
                    isShowedDateRangePicker = true
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Open Date Range Picker"
                )
            }
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Start Date: ${formatDate(startDate)}"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "End Date: ${formatDate(endDate)}"
            )

        }

        if (isShowedDateRangePicker) {
            DatePickerDialog(
                onDismissRequest = {

                    isShowedDateRangePicker = false

                },

                confirmButton = {

                    TextButton(
                        onClick = {
                            startDate = dateRangePickerState.selectedStartDateMillis
                            endDate = dateRangePickerState.selectedEndDateMillis

                            isShowedDateRangePicker = false
                        }
                    ) {
                        Text(
                            text = "OK"
                        )
                    }

                },

                dismissButton = {

                    FilledTonalButton(
                        onClick = {
                            isShowedDateRangePicker = false
                        }
                    ) {
                        Text(
                            text = "Cancel"
                        )
                    }
                }
            ) {
                DateRangePicker(
                    state = dateRangePickerState,
                    title = {
                        Text(
                            text = "Select date range",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    headline = {
                        val start = formatDate(dateRangePickerState.selectedStartDateMillis)
                        val end = formatDate(dateRangePickerState.selectedEndDateMillis)

                        Text(
                            text = "$start - $end",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                                .padding(horizontal = 16.dp),
                            textAlign = TextAlign.Center
                        )
                    },
                    showModeToggle = false,
                    colors = DatePickerDefaults.colors(
                        containerColor = Color(0xFF121212),

                        titleContentColor = Color.Red,
                        headlineContentColor = Color.Cyan,

                        weekdayContentColor = Color.Yellow,

                        selectedDayContainerColor = Color.Blue,
                        selectedDayContentColor = Color.White,

                        todayDateBorderColor = Color.Green,
                        todayContentColor = Color.Green,

                        disabledDayContentColor = Color.Gray,
                        disabledYearContentColor = Color.DarkGray,

                        navigationContentColor = Color.Magenta
                    )
                )
            }
        }


    }
}

fun formatDate(millis: Long?): String {
    if (millis == null) return "Not selected"

    return SimpleDateFormat(
        "dd/MM/yyyy",
        Locale.getDefault() //Uses the device's current language and regional settings.
    ).format(Date(millis)) //Converts milliseconds since January 1, 1970 (Unix Epoch) into a Date.
                           //The formatter converts the Date into a string.
}

/*

   Long: stores large integer values.
   ?: means the value can be null.

 */

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenDatePickerWihRangePreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenDatePickerWithRange {}
    }
}