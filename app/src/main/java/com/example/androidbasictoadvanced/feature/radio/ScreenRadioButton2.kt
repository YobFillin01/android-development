package com.example.androidbasictoadvanced.feature.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


data class RadioModel2(
    val label: String
)

val coffeeOptions = listOf(
    RadioModel2("Ice Latte"),
    RadioModel2("Hot Latte"),
    RadioModel2("Cappuccino"),
    RadioModel2("Espresso"),
    RadioModel2("Americano"),
)

val sizeOption = listOf(
    RadioModel2("Small"),
    RadioModel2("Medium"),
    RadioModel2("Large"),
)

val iceOption = listOf(
    RadioModel2("No Ice"),
    RadioModel2("Less Ice"),
    RadioModel2("Regular Ice"),
    RadioModel2("Extra Ice"),
    RadioModel2("Half Ice"),
)

val milkOption = listOf(
    RadioModel2("No Milk"),
    RadioModel2("25% Milk"),
    RadioModel2("50% Milk"),
    RadioModel2("75% Milk"),
    RadioModel2("100% Milk")
)

val sugarOption = listOf(
    RadioModel2("No Sugar"),
    RadioModel2("25% Sugar"),
    RadioModel2("50% Sugar"),
    RadioModel2("75% Sugar"),
    RadioModel2("100% Sugar")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadioButton2(
    onBack: () -> Unit
) {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val scrollState = rememberScrollState()

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Order Coffee",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = onBack
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

                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),

                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Confirm your order"
                    )
                }
            }

        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Coffee
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Choose Coffee",
                list = coffeeOptions
            )

            HorizontalDivider()

            // Size
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Choose Size",
                list = sizeOption
            )

            HorizontalDivider()

            // Ice
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Choose Ice",
                list = iceOption
            )

            HorizontalDivider()

            // Milk
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Choose Milk",
                list = milkOption
            )

            HorizontalDivider()

            // Sugar
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Choose Sugar",
                list = sugarOption
            )

        }
    }

}

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    title: String,
    list: List<RadioModel2> = emptyList()
) {

    var selectIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        list.forEachIndexed { index, option ->
            Option(
                option = RadioModel2(
                    label = option.label
                ),

                isSelected = selectIndex == index,
                onClick = {
                    selectIndex = index
                }
            )
        }
    }
}

@Composable
fun Option(
    option: RadioModel2,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        RadioButton(
            selected = isSelected,

            onClick = onClick,

            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Black,
                unselectedColor = Color.Gray
            )
        )

        Text(
            text = option.label
        )
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenRadioButton2Preview() {
    AndroidBasicToAdvancedTheme() {
        ScreenRadioButton2 (
            onBack = {}
        )
    }
}