package com.example.androidbasictoadvanced.util

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


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
        ),
    ) {

        Icon(
            painter = painterResource(R.drawable.ic_android),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = Color.Green
        )

    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun LoadingPreview() {
    AndroidBasicToAdvancedTheme {
        Loading()
    }
}