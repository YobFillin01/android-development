package com.example.androidbasictoadvanced.feature.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Blue40
import com.example.androidbasictoadvanced.ui.theme.Blue80
import com.example.androidbasictoadvanced.ui.theme.Brown40
import com.example.androidbasictoadvanced.ui.theme.Green40
import com.example.androidbasictoadvanced.ui.theme.Lime80
import com.example.androidbasictoadvanced.ui.theme.Teal80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCards(
    onBack: () -> Unit
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cards"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back1),
                            contentDescription = "Back",
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),
            )
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

            Text(
                text = "Card is a container used to group related content such as text," +
                        " images, buttons, and icons into a single surface.",
                modifier = Modifier
                    .background(Color.Cyan),
                fontWeight = FontWeight.Bold

            )

            FilledCardExample()
            ElevatedCardExample()
            OutlineCardExample()

        }
    }
}

@Composable
fun FilledCardExample() {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(
                width = 256.dp,
                height = 150.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = Lime80,
            contentColor = Green40
        )
    ) {
        Column(

        ) {
            Text(
                text = "Filled Card!",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = """A Filled Card has a solid 
                    |background color and no strong
                    |shadow.""".trimMargin(),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_forward_arrow),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
fun ElevatedCardExample() {

    ElevatedCard(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .size(
                width = 256.dp,
                height = 150.dp
            ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Brown40,
            contentColor = Teal80
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 24.dp
        ), // add shadow


    ) {

       Column(

       ) {
           Text(
               text = "Elevated Card!",
               modifier = Modifier
                   .padding(start = 16.dp, top = 16.dp),
               fontWeight = FontWeight.Black,
               fontSize = 20.sp
           )

           Row(

               verticalAlignment = Alignment.CenterVertically

           ) {
               Text(
                   text = """
                    An Elevated Card has a shadow 
                    that makes it appear 
                    raised above the screen.
                """.trimIndent(),
                   modifier = Modifier
                       .padding(start = 16.dp, top = 16.dp)
               )
               Spacer(modifier = Modifier.weight(1f))

               IconButton(
                   onClick = {}
               ) {
                   Icon(
                       painter = painterResource(R.drawable.ic_forward_arrow),
                       contentDescription = null,
                   )
               }
           }
       }

    }

}

@Composable
fun OutlineCardExample() {
    OutlinedCard(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp
            )
            .padding(top = 32.dp)
            .size(
                width = 256.dp,
                height = 150.dp
            ),
        colors = CardDefaults.cardColors(
            contentColor = Blue40,
            containerColor = Blue80
        ),
        border = BorderStroke(1.dp, Color.Cyan)

    ) {

        Column(

        ) {
            Text(
                text = "Outline Card!",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp
            )

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = """
                    An Outlined Card has a 
                    border around it instead 
                    of a shadow.
                """.trimIndent(),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_forward_arrow),
                        contentDescription = null,
                    )
                }
            }
        }

    }
}


@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenFilledCardPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenCards {}
    }
}