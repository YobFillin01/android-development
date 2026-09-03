package com.example.androidbasictoadvanced.feature.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun PracticeSegmentButton2() {

    val nameList = listOf(
        "Fillin",
        "Hasanas",
        "Farikin",
        "Sholihah"
    )

    val user1: String = """
        Hello, my name is Fillin! Nice to meet you
    """.trimIndent()

    val user2: String = """
        Hello, my name is Hasanas! Nice to meet you
    """.trimIndent()

    val user3: String = """
        Hello, my name is Farikin! Nice to meet you
    """.trimIndent()

    val user4: String = """
        Hello, my name is Sholihah! Nice to meet you
    """.trimIndent()

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Single Choice Segment Button"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            SingleChoiceSegmentedButtonRow(



            ) {

                nameList.forEachIndexed { index, name ->
                    SegmentedButton(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = nameList.size
                        ),
//                        icon = {
//                            Icon(
//                                painter = painterResource(R.drawable.ic_users),
//                                contentDescription = "User"
//                            )
//                        }
                    ) {
                        Text(
                            text = name
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            when (selectedIndex) {
                0 -> {
                    Text(
                        text = user1
                    )
                }

                1 -> {
                    Text(
                        text = user2
                    )
                }

                2 -> {
                    Text(
                        text = user3
                    )
                }

                3 -> {
                    Text(
                        text = user4
                    )
                }
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun PracticeSegmentButton2Preview() {
    AndroidBasicToAdvancedTheme {
        PracticeSegmentButton2()
    }
}