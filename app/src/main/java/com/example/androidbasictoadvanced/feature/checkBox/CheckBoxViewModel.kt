package com.example.androidbasictoadvanced.feature.checkBox

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class CheckItem(
    val id: Int,
    val title: String,
    val description: String,
    val checked: Boolean
)

class CheckBoxViewModel : ViewModel() {

    val materialComponents = mutableStateListOf(
        CheckItem(1, "Button", "Allows users to perform an action.", false),
        CheckItem(2, "TextField", "Lets users enter text.", false),
        CheckItem(3, "Checkbox", "Allows multiple selections.", false),
        CheckItem(4, "RadioButton", "Allows a single selection.", false),
        CheckItem(5, "Switch", "Turns a setting on or off.", false),
        CheckItem(6, "Card", "Groups related content.", false),
        CheckItem(7, "Slider", "Selects a value from a range.", false),
        CheckItem(8, "ProgressIndicator", "Shows task progress.", false),
        CheckItem(9, "NavigationBar", "Provides navigation.", false),
        CheckItem(10, "FloatingActionButton", "Highlights the main action.", false)
    )

    fun updateChecked(index: Int, checked: Boolean) {
        val item = materialComponents[index]

        materialComponents[index] = item.copy(
            checked = checked
        )
    }

    fun toggleChecked(index: Int) {
        val item = materialComponents[index]

        materialComponents[index] = item.copy(
            checked = !item.checked
        )
    }
}