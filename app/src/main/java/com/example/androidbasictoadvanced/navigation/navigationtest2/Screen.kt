package com.example.androidbasictoadvanced.navigation.navigationtest2

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object ScreenTwo : Screen("screen_two")

    data object ScreenThree : Screen("screen_three")
}