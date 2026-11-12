package com.example.androidbasictoadvanced.feature.fingerprint

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun ScreenFingerPrint(
    onBack: () -> Unit
) {

    val context = LocalContext.current

    val executor = ContextCompat.getMainExecutor(context)



    Scaffold(

        modifier = Modifier
            .navigationBarsPadding(),

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Finger Print"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },

        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {}
            ) {
                Text(
                    text = "Open Finger Print"
                )
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) { }
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenFingerPrintPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenFingerPrint {}
    }
}