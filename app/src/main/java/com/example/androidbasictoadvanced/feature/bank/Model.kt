package com.example.androidbasictoadvanced.feature.bank

import androidx.compose.ui.geometry.RoundRect
import com.example.androidbasictoadvanced.R

data class Button(
    val text: String
)

data class Accounts(
    val icons: Int,
    val title: String,
    val subTitle: String,
    val amount: String,
    val status: String
)

val accountDollarList = listOf(
    Accounts(
        R.drawable.ic_coin,
        "Saving",
        "USD **** 4821",
        "$12,480.50",
        "Available"
    ),

    Accounts(
        R.drawable.ic_coin,
        "Current",
        "USD **** 7305",
        "$3,215.00",
        "Available"
    )
)

val accountKhmerList = listOf(
    Accounts(
        R.drawable.ic_coin,
        "Saving",
        "KHR **** 1190",
        "$12,480.50",
        "Available"
    ),

    Accounts(
        R.drawable.ic_coin,
        "Current",
        "KHR **** 6642",
        "$3,215.00",
        "Available"
    )
)

val buttonList = listOf(
    Button("All"),
    Button("USD"),
    Button("KHR"),
)