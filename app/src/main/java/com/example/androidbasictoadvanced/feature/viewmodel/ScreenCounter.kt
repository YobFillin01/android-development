package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun ScreenCounter() {

    val viewModel: CounterViewModel = viewModel()

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Count: ${viewModel.count}")

        Button(
            onClick = {
                viewModel.increase()
                println("=====> ViewModel")
            }
        ) {
            Text("Increase")
        }

    }

}


@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenCounterPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenCounter ()
    }
}

