package com.example.androidbasictoadvanced.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenCollectAsState() {

    val viewModel: TestVM = viewModel()

    val counter by viewModel.counter.collectAsState()

    println("collectAsState(): $counter")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Collect As State")
        Text(text = "Counter: $counter")
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenCollectAsStatePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenCollectAsState()
    }
}
