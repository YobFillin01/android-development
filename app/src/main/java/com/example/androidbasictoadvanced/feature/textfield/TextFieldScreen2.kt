package com.example.androidbasictoadvanced.feature.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Indigo40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen2( onBack: () -> Unit ) {

    var password by remember { mutableStateOf("") }
    var isPasswordTransform by remember { mutableStateOf(false) }

    var username by remember { mutableStateOf("") }
    val maximumText = username.isNotEmpty()

    var email by remember { mutableStateOf("") }

    Scaffold(

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Indigo40,
                    titleContentColor = Color.White
                ),

                title = {
                    Text(
                        text = "Text Field Types",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
            )
        }

    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Password", fontWeight = FontWeight.Bold)
            TextField(
                value = password,

                onValueChange = { values ->
                    password = values
                },

                label = {Text(text = "Password")},

                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    isPasswordTransform = !isPasswordTransform
                                }
                            ),
                        painter = painterResource(
                            if (isPasswordTransform) R.drawable.ic_eyes else R.drawable.ic_eye_visibility,
                        ),
                        contentDescription = null
                    )
                },

                visualTransformation = if (isPasswordTransform) VisualTransformation.None else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Outlined Text Field", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = username,
                onValueChange = { value ->
                    if (username.length <= 10) {
                        username = value
                    }
                },
                label = {Text(text = "Username")},
                isError = maximumText,
                supportingText = {
                    if (maximumText) Text(text = "Maximum 10 characters")
                }
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Email", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = email,
                onValueChange = { value ->
                    email = value
                },
                label = {Text(text = "Email")},
//                isError = emailError,
            )
        }
    }

}


@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun TextFieldScreen2Preview() {
    AndroidBasicToAdvancedTheme() {
        TextFieldScreen2 {  }
    }
}