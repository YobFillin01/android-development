package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun FavoriteScreen() {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = null
                )
            }
        },
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) { }
    }
}

@Composable
@Preview(showBackground = true)
fun FavoriteScreenPreview() {
    AndroidBasicToAdvancedTheme {
        FavoriteScreen()
    }
}