package com.example.androidbasictoadvanced.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.androidbasictoadvanced.feature.progressindicator.ScreenProgressIndicator

data object Home
data object ProgressIndicator
data object Badge

@Composable
fun BaseNavigation() {

    // Create a back stack, specifying the key the app should start with
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay (
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = {key ->
            when (key) {
                is Home -> NavEntry(key) {
                    ScreenHome(
                        onClickComponent = {id ->
                            println("=====> $id")
                            backStack.add(ProgressIndicator)
                        }
                    )
                }

                is ProgressIndicator -> NavEntry(key) {
                    ScreenProgressIndicator (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                else -> NavEntry(Unit) {
                    Text(text = "unknown route")
                }
            }
        }
    )

}