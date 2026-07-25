package com.example.androidbasictoadvanced.feature.tab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onBack:() -> Unit
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            WalletScreen()

            Spacer(modifier = Modifier.height(16.dp))

            Services()

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(
                    text = "Recent Activity",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .clickable(onClick = {

                        }),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    TextButton(
                        onClick = {}
                    ) {
                        Text(
                            text = "See all",
                            fontSize = 16.sp,
                            color = Color(0xFF5242FF)
                        )
                    }

                    Icon(
                        painter = painterResource(R.drawable.ic_forward_arrow),
                        contentDescription = "forward",
                        modifier = Modifier.size(24.dp)
                    )
                }

            }

            Transactions()
        }
}

@Composable
fun WalletScreen() {

    val items = itemsList

    var isMoneyVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF3924FF),
                        Color(0xFF6D63FF)
                    )
                )
            )
    ) {
        Column(

            modifier = Modifier
                .padding(16.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                Column(

                ) {
                    Row(
//                modifier = Modifier.padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_acc_wallet),
                            contentDescription = "Wallet",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Your Wallet Balance",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(

                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text =  if (isMoneyVisible) "$ 1000.00" else "●●●●●●",
                            color = Color.White,
                            fontWeight = FontWeight.Black,
                            fontSize = 30.sp
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Icon(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .clickable(onClick = {isMoneyVisible = !isMoneyVisible}),
                            painter = painterResource(
                                if (isMoneyVisible) R.drawable.ic_eyes else R.drawable.ic_eye_visibility
                            ),
                            contentDescription = "Eye",
                            tint = Color.White.copy(alpha = 0.5f),
                        )
                    }

                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_qr_scanner),
                        contentDescription = "QR",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items.forEach { items ->

                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(60.dp),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.White
                            )
                        ) {
                            Icon(
                                painter = painterResource(items.icon),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
                                tint = Color(0xFF5242FF)
                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = items.label,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                }
            }

        }
    }

}

data class ItemsModel(
    val icon: Int,
    val label: String,
    val color: Color ?= null,
    val backgroundColor: Color ?= null
)
val itemsList = listOf(
    ItemsModel(R.drawable.ic_coin, "Balance"),
    ItemsModel(R.drawable.ic_transfer2, "Send"),
    ItemsModel(R.drawable.ic_question_mark, "Request"),
    ItemsModel(R.drawable.ic_transfer, "Transfer"),
    ItemsModel(R.drawable.ic_history, "History"),
)

@Composable
fun Services() {
    
    val services1 = serviceList1

    val services2 = serviceList2

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(270.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Text(
            text = "Other Services",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            color = Color.Black
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            services1.forEach { services1 ->

                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(64.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = services1.backgroundColor ?: Color.White
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(services1.icon),
                            contentDescription = "Icon",
                            modifier = Modifier.size(35.dp),
                            tint = services1.color ?: Color.Black
                        )
                    }

                    Text(
                        text = services1.label,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            services2.forEach { services2 ->

                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(64.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = services2.backgroundColor ?: Color.White
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(services2.icon),
                            contentDescription = "Icon",
                            modifier = Modifier.size(35.dp),
                            tint = services2.color ?: Color.Black
                        )
                    }

                    Text(
                        text = services2.label,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }
    }
}

val serviceList1 = listOf(
    ItemsModel(R.drawable.ic_invoice, "Create Invoice", Color.Blue, Color(0xFFE3F2FD)),
    ItemsModel(R.drawable.ic_bills, "Pay Bills", Color(0xFFFF9800), Color(0xFFFFF3E0)),
    ItemsModel(R.drawable.ic_account_balance, "Bank Transfer", Color(0xFFE53935), Color(0xFFFFEBEE)),
    ItemsModel(R.drawable.ic_clock, "Savings", Color(0xFF43A047), Color(0xFFE8F5E9)),
)
val serviceList2 = listOf(
    ItemsModel(R.drawable.ic_light, "Electricity", Color(0xFF43A047), Color(0xFFE8F5E9)),
    ItemsModel(R.drawable.ic_movie, "Movie", Color.Blue, Color(0xFFE3F2FD)),
    ItemsModel(R.drawable.ic_acc_wallet, "Add Money", Color(0xFFFF9800), Color(0xFFFFF3E0)),
    ItemsModel(R.drawable.ic_share, "Share", Color(0xFFE53935), Color(0xFFFFEBEE)),
)

@Composable
fun Transactions() {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        items(historyList) { history ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(history.icon),
                    contentDescription = "Picture",
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = history.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = history.transaction,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = history.color ?: Color.Red
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = history.sendAndReceive,
                            fontSize = 13.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = history.date,
                            fontSize = 13.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }
}

data class TransactionModel(
    val icon: Int,
    val name: String,
    val sendAndReceive: String,
    val transaction: String,
    val date: String,
    val color: Color ?= null
)

val historyList = listOf(
    TransactionModel(
        R.drawable.img_profile,
        "Sok Dara",
        "Send Money",
        "-$56.90",
        "25-07-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Chan Somnang",
        "Receive Money",
        "+$100.00",
        "03-07-2026",
        Color(0xFF08A600)
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Vannak Chea",
        "Send Money",
        "-$25.00",
        "01-07-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Dara Sopheak",
        "Receive Money",
        "+$250.00",
        "28-06-2026",
        Color(0xFF08A600)
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Maly Rith",
        "Send Money",
        "-$75.50",
        "22-06-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Pheaktra Kim",
        "Receive Money",
        "+$80.00",
        "18-06-2026",
        Color(0xFF08A600)
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Sreyneang Ly",
        "Send Money",
        "-$120.00",
        "15-06-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Sokha Lim",
        "Receive Money",
        "+$45.75",
        "10-06-2026",
        Color(0xFF08A600)
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Ratanak Heng",
        "Send Money",
        "-$35.25",
        "05-06-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Bopha Chhun",
        "Receive Money",
        "+$300.00",
        "01-06-2026",
        Color(0xFF08A600)
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Sovann Makara",
        "Send Money",
        "-$90.00",
        "27-05-2026",
        Color.Red
    ),
    TransactionModel(
        R.drawable.img_profile,
        "Kosal Vireak",
        "Receive Money",
        "+$150.00",
        "20-05-2026",
        Color(0xFF08A600)
    )
)



@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        HomeScreen {  }
    }
}