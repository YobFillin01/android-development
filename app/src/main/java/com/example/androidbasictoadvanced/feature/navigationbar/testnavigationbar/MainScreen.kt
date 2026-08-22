package com.example.androidbasictoadvanced.feature.navigationbar.testnavigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    onClick = {
                        navController.navigate("Home")
                    },
                    selected = false,
                    label = {
                        Text(
                            text = "Home"
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = null
                        )
                    }
                )

                NavigationBarItem(
                    onClick = {
                        navController.navigate("Favorite")
                    },
                    selected = false,
                    label = {
                        Text(
                            text = "Favorite"
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite),
                            contentDescription = null
                        )
                    }
                )

                NavigationBarItem(
                    onClick = {
                        navController.navigate("Menu")
                    },
                    selected = false,
                    label = {
                        Text(
                            text = "Menu"
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(paddingValues)
        ) {

            composable("Home") {
                HomeScreen()
            }

            composable("Favorite") {
                FavoriteScreen()
            }

            composable("Menu") {
                MenuScreen()
            }

        }
    }

}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    AndroidBasicToAdvancedTheme {
        MainScreen()
    }
}