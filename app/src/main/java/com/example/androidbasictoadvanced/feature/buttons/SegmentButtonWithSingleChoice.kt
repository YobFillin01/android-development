package com.example.androidbasictoadvanced.feature.buttons
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.androidbasictoadvanced.practice.screenUI.HorizontalLine
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSegmentButtonWithSingleChoice(
    onBack: () -> Unit
) {

    val list = listOf(
        TransactionType.MOBILE_TOP_UP,
        TransactionType.ABA_TRANSFER,
        TransactionType.KHQR_PAYMENT,
        TransactionType.INTERNET_BILL
    )

    var selectIndex by remember { mutableIntStateOf(0) }

    var transactionFilter by remember { mutableStateOf<List<TransactionModel>?>(transactionList) }

    fun onFilter() {
        transactionFilter = transactionList.filter {
            it.type == list[selectIndex]
        }
    }

    Scaffold(

        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Single Choice Segmented Button"
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    transactionFilter = transactionList
                }
            ) {
                Text(
                    text = "Clear"
                )
            }
        }

    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                list.forEachIndexed { index, item ->
                    SegmentedButton(
                        selected = index == selectIndex,
                        onClick = {
                            selectIndex = index
                            transactionFilter = transactionList.filter {
                                it.type == list[index]
                            }
                        },

                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 16.dp else 0.dp,
                            bottomStart = if (index == 0) 16.dp else 0.dp,
                            bottomEnd = if (index == list.size - 1) 16.dp else 0.dp,
                            topEnd = if (index == list.size - 1) 16.dp else 0.dp
                        ),

                        label = {
                            Text(
                                text = item.type
                            )
                        }
                    )
                }
            }
            transactionFilter?.forEach { model ->
                Row(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "${model.id} - ${model.title}"
                    )
                }
                HorizontalLine()
            }
        }
    }
}

enum class TransactionType(val id: String, val type: String) {

    ABA_TRANSFER("001", "Transfer"),
    KHQR_PAYMENT("003", "Payment"),
    MOBILE_TOP_UP("006", "Top Up"),
    INTERNET_BILL("009", "Internet"),
}

data class TransactionModel(
    val id: String,
    val title: String,
    val amount: Double,
    val date: String,
    val type: TransactionType,
    val isIncome: Boolean
)

val transactionList = listOf(

    TransactionModel(
        id = "TRX001",
        title = "Smart Mobile Top Up",
        amount = 5.0,
        date = "29 May 2026",
        type = TransactionType.MOBILE_TOP_UP,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX002",
        title = "ABA Transfer to Dara",
        amount = 50.0,
        date = "28 May 2026",
        type = TransactionType.ABA_TRANSFER,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX003",
        title = "KHQR Coffee Payment",
        amount = 3.5,
        date = "28 May 2026",
        type = TransactionType.KHQR_PAYMENT,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX004",
        title = "Home Internet Bill",
        amount = 25.0,
        date = "27 May 2026",
        type = TransactionType.INTERNET_BILL,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX005",
        title = "Cellcard Top Up",
        amount = 10.0,
        date = "26 May 2026",
        type = TransactionType.MOBILE_TOP_UP,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX006",
        title = "ABA Transfer to Mom",
        amount = 100.0,
        date = "25 May 2026",
        type = TransactionType.ABA_TRANSFER,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX007",
        title = "KHQR Restaurant Payment",
        amount = 15.0,
        date = "24 May 2026",
        type = TransactionType.KHQR_PAYMENT,
        isIncome = false
    ),

    TransactionModel(
        id = "TRX008",
        title = "Office Internet Subscription",
        amount = 40.0,
        date = "23 May 2026",
        type = TransactionType.INTERNET_BILL,
        isIncome = false
    )

)

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenSegmentButtonWithSingleChoicePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenSegmentButtonWithSingleChoice {}
    }
}