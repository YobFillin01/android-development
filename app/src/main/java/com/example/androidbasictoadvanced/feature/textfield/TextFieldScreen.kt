package com.example.androidbasictoadvanced.feature.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Indigo40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(
    onBack: () -> Unit
) {

    var tel by remember { mutableStateOf("") }

    val numberError = tel.isNotEmpty() && !tel.all{ number -> number.isDigit() }

    Scaffold(

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                title = {
                    Text(
                        text = "Text Field",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {
                            
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = tel,

                onValueChange = { tels ->
                    tel = tels
                },

                enabled = true,

                readOnly = false, // If it's true, cannot be input

//                label = { Text(text = "Tel:") },

                placeholder = { Text(text = "Phone number") },

                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_call),
                        contentDescription = "Search"
                    )
                },

                trailingIcon = { }, // Icon at the right

//                prefix = { Text(text = "+855") }, // text at the left

                suffix = { }, // text at the right

                isError = numberError,

                supportingText = {
                    if (numberError) {
                        Text("Please enter numbers only")
                    }
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                // Control the type of keyboard that appears when the user taps the input field.

                shape = RoundedCornerShape(8.dp),

                visualTransformation = PasswordVisualTransformation()


            )
        }
    }

}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun TextFieldScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        TextFieldScreen {  }
    }
}