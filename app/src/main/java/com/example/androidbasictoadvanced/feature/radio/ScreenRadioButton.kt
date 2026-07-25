package com.example.androidbasictoadvanced.feature.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


data class RadioModel(
    val label: String
)

val optionList = listOf(
    RadioModel("Java"),
    RadioModel("Kotlin"),
    RadioModel("C"),
    RadioModel("C++"),
    RadioModel("Python"),
    RadioModel("HTML"),
    RadioModel("CSS"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadioButton(
    onBack: () -> Unit
) {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val options = optionList

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Radio Button",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            options.forEachIndexed { index, option ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    RadioButton(
                        selected = index == selectedIndex,

                        onClick = {
                            selectedIndex = index
                        },

                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Red,
                            unselectedColor = Color.Black
                        )
                    )

                    Text(
                        text = option.label
                    )
                }

            }


        }
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenRadioButtonPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenRadioButton (
            onBack = {}
        )
    }
}