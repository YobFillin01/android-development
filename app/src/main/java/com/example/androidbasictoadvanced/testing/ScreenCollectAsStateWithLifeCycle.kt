package com.example.androidbasictoadvanced.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Suppress("ParamsComparedByRef")
@Composable
fun ScreenCollectAsStateWithLifeCycle() {

    val viewModel: TestVM = viewModel()

    val counter by viewModel.counter.collectAsStateWithLifecycle()

    println("collectAsStateWithLifecycle(): $counter")

    Column(

        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text("collectAsStateWithLifecycle")
        Text("Counter: $counter")

    }
}

@Composable
@Preview(showBackground = true)
fun ScreenCollectAsStateWithLifeCyclePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenCollectAsStateWithLifeCycle()
    }
}