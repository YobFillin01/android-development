package com.example.androidbasictoadvanced.vetexpress

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomModel(
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector,
    val title: String? = null
)

data class Boxes(
    val image: Int,
    val text: String
)

data class Service(
    val icon: ImageVector,
    val text: String
)

data class Accommodation(
    val image: Int,
    val title: String,
    val price: String,
)
