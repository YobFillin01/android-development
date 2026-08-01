package com.example.androidbasictoadvanced.feature.buttonsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.radio.OrderSection
import com.example.androidbasictoadvanced.feature.radio.coffeeOptions
import com.example.androidbasictoadvanced.feature.radio.iceOption
import com.example.androidbasictoadvanced.feature.radio.sizeOption
import com.example.androidbasictoadvanced.feature.radio.sugarOption
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomSheet(
    onBack: () -> Unit
) {

    var showBottomSheetState by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState  (
        skipPartiallyExpanded = true // expand when has lots of content on it.
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bottom Sheet",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },

        bottomBar = {

            Row(

                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    modifier = Modifier
                        .padding(16.dp),

                    onClick = {
                        showBottomSheetState = true
                    },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),

                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Open Bottom Sheet"
                    )
                }
            }
        }

    ){ paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

            if (showBottomSheetState) {
                ModalBottomSheet(

                    onDismissRequest = { showBottomSheetState = false },

                    dragHandle = null,

                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp)
                            .verticalScroll(rememberScrollState()),
                    ) {

                        Row(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 140.dp),
                            verticalAlignment = Alignment.CenterVertically,

                        ) {
                            Text(
                                text = "Order Coffee",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            IconButton(
                                onClick = {showBottomSheetState = false}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_close),
                                    contentDescription = "Close"
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider()

                        OrderSection(
                            modifier = Modifier.padding(top = 16.dp),
                            title = "Choose Coffee",
                            list = coffeeOptions
                        )

                        OrderSection(
                            modifier = Modifier.padding(top = 16.dp),
                            title = "Choose Coffee",
                            list = sizeOption
                        )

                        OrderSection(
                            modifier = Modifier.padding(top = 16.dp),
                            title = "Choose Coffee",
                            list = iceOption
                        )

                        OrderSection(
                            modifier = Modifier.padding(top = 16.dp),
                            title = "Choose Coffee",
                            list = sugarOption
                        )

                    }
                }
            }

        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenBottomSheetPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenBottomSheet {  }
    }
}