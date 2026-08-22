package com.example.androidbasictoadvanced.navigation.navigationtest1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenB(
    onNavigateBackToA:() -> Unit,
    onNavigateToC:() -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Screen B"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onNavigateBackToA()
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "Back"
                )

                Text(
                    text = "Navigate to screen A"
                )
            }
        }

        Button(
            onClick = {
                onNavigateToC()
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Navigate to screen C"
                )

                Icon(
                    painter = painterResource(R.drawable.ic_forward_arrow),
                    contentDescription = "Back"
                )

            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenBPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenB (
            onNavigateBackToA = {},
            onNavigateToC = {}
        )
    }
}