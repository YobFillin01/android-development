package com.example.androidbasictoadvanced.feature.checkBox


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCheckBox2(
    onBack: () -> Unit,
    viewModel: CheckBoxViewModel = viewModel()
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Check Box"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back1),
                            contentDescription = "Back"
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                )
            )
        }

    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {

            itemsIndexed(
                items = viewModel.materialComponents,
                key = { _, item -> item.id }
            ) { index, item ->

                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable {
                            viewModel.toggleChecked(index)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        checked = item.checked,
                        onCheckedChange = { isChecked ->
                            viewModel.updateChecked(index, isChecked)
                        }
                    )

                    Column {

                        Text(
                            text = item.title,
                            textDecoration =
                                if (item.checked) {
                                    TextDecoration.Underline
                                } else {
                                    TextDecoration.None
                                }
                        )

                        Text(
                            text = item.description,
                            fontSize = 12.sp
                        )
                    }
                }

                HorizontalDivider()
            }
        }
    }
}

@Composable
@Preview(
    name = "Phone",
    device = Devices.PIXEL_9_PRO,
    showSystemUi = true
)
fun ScreenCheckBox2Preview() {

    AndroidBasicToAdvancedTheme {
        ScreenCheckBox2(
            onBack = {}
        )
    }
}