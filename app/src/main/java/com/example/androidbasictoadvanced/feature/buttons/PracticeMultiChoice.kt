package com.example.androidbasictoadvanced.feature.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.radio.optionList
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlin.random.Random

@Composable
fun PracticeMultiChoice() {

    val iconList = listOf(
        "Setting",
        "Home",
        "Menu",
        "Notification"
    )

    val selectedOptions = remember { mutableStateListOf(true, false, false, false)  }

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Multi Choice Segment Button"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MultiChoiceSegmentedButtonRow {

                iconList.forEachIndexed { index, icon ->
                    SegmentedButton(
                        checked = selectedOptions[index],
                        onCheckedChange = {
                            selectedOptions[index] = !selectedOptions[index]
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = iconList.size
                        ),
                        icon = {
                            SegmentedButtonDefaults.Icon(selectedOptions[index])
                        },

                        label = {
                            when (icon) {
                                "Setting" -> {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_setting),
                                        contentDescription = null
                                    )
                                }

                                "Home" -> {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_home1),
                                        contentDescription = null
                                    )
                                }

                                "Menu" -> {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_menu),
                                        contentDescription = null
                                    )
                                }

                                "Notification" -> {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_notification),
                                        contentDescription = null
                                    )
                                }
                            }
                        }

                    )
                }

            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PracticeMultiChoicePreview() {
    AndroidBasicToAdvancedTheme {
        PracticeMultiChoice()
    }
}