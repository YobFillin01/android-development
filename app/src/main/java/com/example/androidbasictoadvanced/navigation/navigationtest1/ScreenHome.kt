package com.example.androidbasictoadvanced.navigation.navigationtest1

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenHome() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ScreenA"
    ) {
        composable(
            "ScreenA"
        ) {

            ScreenA(
                onNavigateToB = {
                    navController.navigate("ScreenB")
                },

                onNavigateToC = {
                    navController.navigate("ScreenC")
                }
            )

        }

        composable("screenB") {
            ScreenB(
                onNavigateBackToA = {
                    navController.popBackStack()
                },

                onNavigateToC = {
                    navController.navigate("ScreenC")
                }
            )
        }

        composable(
            "ScreenC"
        ) {

            ScreenC(
                navigateBackToB = {
                    navController.popBackStack()
                },

                navigateBackToA = {
                    navController.popBackStack("ScreenA", false)
                }
            )

        }
    }

}

@Composable
@Preview(showBackground = true)
fun ScreenHomePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenHome()
    }
}