package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenMobileTopUp(
    onBack:() -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF0D3157))
            .fillMaxSize(),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    onBack()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back_new),
                    contentDescription = null,
                    tint = Color.White
                )
            }

//            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Mobile Top-Up",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Column(

            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(R.drawable.img_smart),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Smart",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .background(Color.White)
        ) {

            val lists = listOf(
                "PINLess",
                "PIN Voucher"
            )

            var selectedOptions by remember { mutableIntStateOf(0) }

            SingleChoiceSegmentedButtonRow (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {

                lists.forEachIndexed { index, list ->
                    SegmentedButton(
                        selected = selectedOptions == index,
                        onClick = {
                            selectedOptions = index
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = lists.size
                        ),
                        colors = SegmentedButtonDefaults.colors(
                            activeContainerColor = Color(0xFFBF9A33),
                            inactiveContainerColor = Color.LightGray.copy(alpha = 0.5f)
                        ),
                        icon = {},
                        border = BorderStroke(
                            width = 0.dp,
                            color = Color.White
                        )
                    ) {
                        Text(
                            text = list,
                            color = if (selectedOptions == index) Color.White else Color(0xFFBF9A33)
                        )
                    }
                }

            }

            when (selectedOptions) {
                0 -> {
                    PINLess()
                }

                1 -> {
                    PinVoucher()
                }
            }

        }
    }
}

data class ChoiceModel(
    val amount: String,
    val days: String
)

val choiceList = listOf(
    ChoiceModel("$1.5", "8 days"),
    ChoiceModel("$2", "15 days"),
    ChoiceModel("$3.25", "15 days"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PINLess() {

    var fromAccount by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var topUpAmount by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val choice = choiceList


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = fromAccount,
            onValueChange = { value ->
                fromAccount = value
            },
            label = {
                Text(
                    text = "From Account"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        showBottomSheet = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_drop_down),
                        contentDescription = null,
                        tint = Color(0xFFBF9A33)
                    )
                }
            },

            shape = RoundedCornerShape(8.dp)
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                dragHandle = null,
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFBF9A33),
                                        Color.Black
                                    )
                                )
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Select Account",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    ) {
                        Column(

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "069****59",
                                    fontSize = 20.sp,
                                    color = Color(0xFF0D3157),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "KHR",
                                    fontSize = 20.sp,
                                    color = Color(0xFFBF9A33),
                                    fontWeight = FontWeight.Bold

                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Wallet",
                                    fontSize = 20.sp,
                                    color = Color.Gray,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "187,0000",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFBF9A33),
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    ) {
                        Column(

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "069****59",
                                    fontSize = 20.sp,
                                    color = Color(0xFF0D3157),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "USD",
                                    fontSize = 20.sp,
                                    color = Color(0xFF0D3157),
                                    fontWeight = FontWeight.Bold

                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Wallet",
                                    fontSize = 20.sp,
                                    color = Color.Gray,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "2,560,000",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0D3157),
                                )
                            }
                        }
                    }

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mobileNumber,
            onValueChange = { value ->
                mobileNumber = value
            },
            label = {
                Text(
                    text = "Mobile Number"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_users),
                        contentDescription = null
                    )
                }
            },

            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Top Up Main Balance"
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = topUpAmount,
            onValueChange = { value ->
                topUpAmount = value
            },
            label = {
                Text(
                    text = "Enter Top Up Amount ($1 - $50)"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = null
                    )
                }
            },

            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            choice.forEach { choice ->

                Box(
                    modifier = Modifier
                        .size(
                            height = 80.dp,
                            width = 120.dp
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.5f))
                        .border(
                            width = 1.dp,
                            color = Color.Black.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = choice.amount,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D3157)
                        )
                        Text(
                            text = choice.days,
                            color = Color.Gray
                        )
                    }
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinVoucher() {

    var fromAccount2 by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var mobileOperator by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = fromAccount2,
            onValueChange = { value ->
                fromAccount2 = value
            },
            label = {
                Text(
                    text = "From Account"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        showBottomSheet = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_drop_down),
                        contentDescription = null,
                        tint = Color(0xFFBF9A33)
                    )
                }
            },

            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = mobileOperator,
            onValueChange = { value ->
                mobileOperator = value
            },
            label = {
                Text(
                    text = "Mobile Operator"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_wifi),
                        contentDescription = null,
                        tint = Color(0xFFBF9A33)
                    )
                }
            },

            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Save to Favorites",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = checked,
                onCheckedChange = { enable ->
                    checked = enable
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Black,
                    uncheckedTrackColor = Color.White,
                    uncheckedThumbColor = Color.Black
                ),

            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                dragHandle = null,
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFBF9A33),
                                        Color.Black
                                    )
                                )
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Select Account",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    ) {
                        Column(

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "069****59",
                                    fontSize = 20.sp,
                                    color = Color(0xFF0D3157),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "KHR",
                                    fontSize = 20.sp,
                                    color = Color(0xFFBF9A33),
                                    fontWeight = FontWeight.Bold

                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Wallet",
                                    fontSize = 20.sp,
                                    color = Color.Gray,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "187,0000",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFBF9A33),
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    ) {
                        Column(

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "069****59",
                                    fontSize = 20.sp,
                                    color = Color(0xFF0D3157),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "USD",
                                    fontSize = 20.sp,
                                    color = Color(0xFFBF9A33),
                                    fontWeight = FontWeight.Bold

                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Wallet",
                                    fontSize = 20.sp,
                                    color = Color.Gray,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "256,000",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFBF9A33),
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenMobileTopUpPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenMobileTopUp {}
    }
}