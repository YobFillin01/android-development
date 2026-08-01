package com.example.androidbasictoadvanced.feature.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSegmentButtonWithMultiChoice(
    onBack: () -> Unit
) {

    val selectOption = remember {
        mutableStateListOf (true, false, false, false)
    }
    val option = listOf<String>(
        "Top Up",
        "Transfer",
        "Payment",
        "Internet")

    val transactionTypeList = listOf(
        TransactionType.MOBILE_TOP_UP,
        TransactionType.ABA_TRANSFER,
        TransactionType.KHQR_PAYMENT,
        TransactionType.INTERNET_BILL
    )

    var transactionFilter by remember {
        mutableStateOf(
            transactionList.filter {
                it.type == TransactionType.MOBILE_TOP_UP
            }
        )
    }

    Scaffold(

        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Segment button with multi choice"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "back"
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
        ) {

            MultiChoiceSegmentedButtonRow(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()

            ) {

                option.forEachIndexed { index, select ->
                    SegmentedButton(
                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 16.dp else 0.dp,
                            bottomStart = if (index == 0) 16.dp else 0.dp,
                            bottomEnd = if (index == option.size - 1) 16.dp else 0.dp,
                            topEnd = if (index == option.size - 1) 16.dp else 0.dp
                        ),
                        checked = selectOption[index],
                        onCheckedChange = {

                            selectOption[index] = !selectOption[index]

                            val selectedTypes = transactionTypeList.filterIndexed { i, _ ->
                                selectOption[i]
                            }

                            transactionFilter = transactionList.filter {
                                it.type in selectedTypes
                            }

                            println(select)
                        },
                        icon = { SegmentedButtonDefaults.Icon(selectOption[index]) },
                        label = {
                            Text(
                                text = select
                            )
                        }
                    )
                }
            }

            transactionFilter.forEach { transaction ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "${transaction.id} - ${transaction.title}"
                    )
                }

                HorizontalDivider()
            }

        }
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenSegmentButtonWithMultiChoicePreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenSegmentButtonWithMultiChoice {}
    }
}