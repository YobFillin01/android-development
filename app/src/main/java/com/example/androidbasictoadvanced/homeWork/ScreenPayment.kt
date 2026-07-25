package com.example.androidbasictoadvanced.homeWork

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

data class PaymentItem(
    val title: String,
    val icon: Int
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screenPayment() {

    val paymentList = listOf(
        PaymentItem("Education", R.drawable.ic_school),
        PaymentItem("Electricity", R.drawable.ic_bolt),
        PaymentItem("Water Supply", R.drawable.ic_water),
        PaymentItem("Financial ans Investment", R.drawable.ic_account_balance),
        PaymentItem("Solid wast", R.drawable.ic_delete),
        PaymentItem("Public Service", R.drawable.ic_public),
        PaymentItem("Charity and Donation", R.drawable.ic_heart),
        PaymentItem("Insurance", R.drawable.ic_insurance),
        PaymentItem("WiFi", R.drawable.ic_wifi),
        PaymentItem("Credit Score", R.drawable.ic_credit_score),
    )

    Scaffold(

        topBar = {
            TopAppBar(

                title = {
                    Text(
                        text = "Payment",
                        color = Color.Black,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFEBEB)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Arrow Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFFFEBEB)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = "Menu",
                            tint = Color.Black
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add),
                            contentDescription = "Add",
                            tint = Color.Black
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = "Home",
                            tint = Color.Black
                        )
                    }
                }
            }
        }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(paymentList) { item ->
                PaymentRow(item)
            }
        }

    }

}
@Composable
fun PaymentRow(item: PaymentItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFD6D6D6),
                shape = RoundedCornerShape(16.dp)
                )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(item.icon),
            contentDescription = item.title,
            tint = Color.Black
        )

        Text(
            text = item.title,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun screenPaymentPreview() {
    AndroidBasicToAdvancedTheme() {
        screenPayment()
    }
}