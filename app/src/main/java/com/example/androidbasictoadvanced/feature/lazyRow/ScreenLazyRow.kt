package com.example.androidbasictoadvanced.feature.lazyRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme



data class MovieItem (
    val tile: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingMovies () {

    val movieList = listOf(
        MovieItem ("The Nun", R.drawable.the_nun)
    )

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color (0xFFD6D6D6)
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Back",
                            tint = Color (0xFFD6D6D6)
                        )
                    }
                },

                title = {
                    Text(
                        text = "Trending Movies"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6792C2),
                    titleContentColor = Color(0xFFD6D6D6)
                )

            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color (0xFF111111)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Menu",
                            tint = Color (0xFFD6D6D6)
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add),
                            contentDescription = "Menu",
                            tint = Color (0xFFD6D6D6)
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = "Menu",
                            tint = Color (0xFFD6D6D6)
                        )
                    }


                }
            }
        }

    ) { innerPadding ->
        LazyRow(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }

    }

}

@Composable
@Preview (showBackground = true)
fun TrendingMoviesPreview () {
    AndroidBasicToAdvancedTheme() {
        TrendingMovies ()
    }
}