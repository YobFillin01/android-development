package com.example.androidbasictoadvanced.feature.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.practice.screenUI.HorizontalLine
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Indigo40
import com.example.androidbasictoadvanced.ui.theme.Lime40
import com.example.androidbasictoadvanced.ui.theme.Mint40
import com.example.androidbasictoadvanced.ui.theme.Red40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenButtons(
    onBack: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Buttons"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            IconButton()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            Button()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            FilledTonalButton()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            ElevateButton()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
            Spacer(modifier = Modifier.height(8.dp))
            TextButton()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalLine()
        }
    }

}

@Composable
fun IconButton() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                print("==>You click icon button.")
            },
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.background,
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = Red40,
                disabledContainerColor = Lime40
            ),
            shape = RoundedCornerShape(8.dp),
            enabled = true
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "Add"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Icon button"
        )
    }
}
@Composable
fun Button() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                print("===> You clicked the buton")
            },
            border = BorderStroke(width = 2.dp, color = Color.Black),

            shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp),

            colors = ButtonDefaults.buttonColors(Color.Red)

        ) {
            Text(
                text = "Download"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Button"
        )
    }
}

@Composable
fun FilledTonalButton() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledTonalButton(
            onClick = {},
        ) {
            Text(
                text = "Favorite"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Filled button"
        )
    }
}

@Composable
fun ElevateButton() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedButton(
            onClick = {},
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 15.dp, // shadow
                pressedElevation = 5.dp,
                hoveredElevation = 10.dp
            ),

            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Indigo40,
                contentColor = Mint40
            )

        ) {
            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = "Share"
                )

                Text(
                    text = "Share"
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Elevate button"
        )
    }
}
@Composable
fun OutlinedButton() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = {}
        ) {
            Text(
                text = "Cancel"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Outlined button"
        )
    }
}

@Composable
fun TextButton() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Skip"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Text button"
        )
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenButtonsPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenButtons {}
    }
}