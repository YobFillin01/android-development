package com.example.androidbasictoadvanced.feature.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlin.random.Random


@Composable
fun PracticeSegmentButton() {

    val options = listOf("Java", "Kotlin", "C#", "Python")

    val java: String = """
        A general-purpose, object-oriented programming language designed to be portable across different platforms through the JVM (Java Virtual Machine).
    """.trimIndent()

    val kotlin: String = """
        A modern, statically typed programming language developed by JetBrains. It is fully interoperable with Java and is widely used for Android development.
    """.trimIndent()

    val cShape: String = """
        A modern, object-oriented programming language developed by Microsoft, primarily used with the .NET platform.
    """.trimIndent()

    val python: String = """
        A high-level, dynamically typed programming language designed to emphasize readable and concise code.
    """.trimIndent()


    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Practice Segment button"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SingleChoiceSegmentedButtonRow {

                options.forEachIndexed { index, option ->
                    SegmentedButton(

                        selected = selectedIndex == index,

                        onClick = { selectedIndex = index },

                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),

                    ) {
                        Text(
                            text = option
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            when (selectedIndex) {

                0 -> {
                    Text(
                        text = java
                    )
                }

                1 -> {
                    Text(
                        text = kotlin
                    )
                }

                2 -> {
                    Text(
                        text = cShape
                    )
                }

                3 -> {
                    Text(
                        text = python
                    )
                }
            }

        }
    }

}

@Composable
@Preview(showBackground = true)
fun PracticeSegmentButtonPreview() {
    AndroidBasicToAdvancedTheme {
        PracticeSegmentButton()
    }
}