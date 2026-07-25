package com.example.androidbasictoadvanced.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
data class PaymentItem (
        val title: String,
        val icon: Int
        )
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPayment () {

    val paymentList = listOf(
        PaymentItem("Trick's Treat", R.drawable.image_trickrtreat),
        PaymentItem("The Conjuring", R.drawable.the_conjuring),
        PaymentItem("A Quiet Place", R.drawable.a_quiet_place),
        PaymentItem("AnnaBella", R.drawable.annabella),
        PaymentItem("Dark Water", R.drawable.dark_water),
        PaymentItem("Host", R.drawable.host),
        PaymentItem("Insidious", R.drawable.insidious),
        PaymentItem("IT", R.drawable.it),
        PaymentItem("Light Out", R.drawable.light_out),
        PaymentItem("MaMa", R.drawable.mama),
        PaymentItem("Oculus", R.drawable.oculus),
        PaymentItem("Poltergeist", R.drawable.poltergeist),
        PaymentItem("Saw", R.drawable.saw),
        PaymentItem("Scream", R.drawable.scream),
        PaymentItem("The Babadook", R.drawable.the_babadook),
        PaymentItem("The blair witch project", R.drawable.the_blair_witch_project),
        PaymentItem("The Nun", R.drawable.the_nun),
        PaymentItem("Train to busan", R.drawable.traint_to_busan),
    )

    Scaffold(

        topBar = {
            TopAppBar(

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

                title = {
                    Text(
                        text = "Horror movie",
                        color = Color.White
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00820C)
                )
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF00820C)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home1),
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite),
                            contentDescription = "Shop",
                            tint = Color.White
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_shop),
                            contentDescription = "Shop",
                            tint = Color.White
                        )
                    }
                }
            }
        }


    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(paymentList) { item ->
                PaymentRow(item)
            }
        }
    }
}
@Composable
fun PaymentRow (item: PaymentItem) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(
                color = Color(0xFFBDBDBD),
                shape = RoundedCornerShape(10.dp)
            )
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            modifier = Modifier
//                .padding(start = 3.dp)
                .size(90.dp)
        )

        Text(
            text = item.title,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
@Preview (showBackground = true)
fun ScreenPaymentPreview () {
    AndroidBasicToAdvancedTheme() {
        ScreenPayment()
    }
}