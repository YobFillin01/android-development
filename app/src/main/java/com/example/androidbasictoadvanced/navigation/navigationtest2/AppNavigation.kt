package com.example.androidbasictoadvanced.navigation.navigationtest2

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            FirstScreen(
                onNavigateToSecond = {
                    navController.navigate(Screen.ScreenTwo.route)
                },
                onNavigateToThird = {
                    navController.navigate(Screen.ScreenThree.route)
                }
            )
        }

        composable(Screen.ScreenTwo.route) {
            SecondScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.ScreenThree.route) {
            ThirdScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppNavigationPreview() {
    AndroidBasicToAdvancedTheme {
        AppNavigation()
    }
}