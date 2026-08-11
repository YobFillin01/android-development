package com.example.androidbasictoadvanced.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


object LoadingUtil {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    var isLoading = _isLoading

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun Loading() {
    BasicAlertDialog(
        onDismissRequest = {},

        properties = DialogProperties(
            dismissOnBackPress = true,

            dismissOnClickOutside = false
        )

    ) {

        Box(

            modifier = Modifier
                .size(256.dp),
            contentAlignment = Alignment.Center

        ) {
            CircularWavyProgressIndicator(

                color = Color(0xFF15FF00),
                trackColor = Color(0xFF15FF00).copy(alpha = 0.5f),


            )
        }


    }
}