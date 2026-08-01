package com.example.androidbasictoadvanced.feature.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSlider(
    onBack: () -> Unit
) {

    var sliderValue by remember { mutableFloatStateOf(0f) }

    var sliderStep by remember { mutableFloatStateOf(0f) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Slider",
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
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "S Normal slider",
                modifier = Modifier.padding(start = 32.dp),
                fontWeight = FontWeight.Bold
            )

            Row(

                modifier = Modifier
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Slider(

                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),

                    value = sliderValue,
                    onValueChange = { value ->

                        sliderValue = value

                    }

                )

                Text(
                    modifier = Modifier.width(50.dp),
                    text = "${(sliderValue*100).roundToInt()}%"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Step Slider",
                modifier = Modifier.padding(start = 32.dp),
                fontWeight = FontWeight.Bold
            )

            Row(

                modifier = Modifier
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Slider(

                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),

                    value = sliderStep,
                    onValueChange = { value ->

                        sliderStep = value

                    },

                    steps = 3,

                    valueRange = 0f..100f

                )

                Text(
                    modifier = Modifier.width(50.dp),
                    text = "$${sliderStep.roundToInt()}"
                )
            }

        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenSliderPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenSlider {  }
    }
}