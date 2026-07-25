package com.example.androidbasictoadvanced.feature.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Orange40


data class FavoriteItem(
    val icon: Int,
    val transfer: String,
    val receiverAccount: String
)

val transferList = listOf(
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Lim Hasanas",
        "ABA **** 4567"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Sok Dara",
        "ACLEDA **** 1234"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Chan Vanna",
        "ABA **** 5678"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Kim Sopheak",
        "Wing **** 9876"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Heng Rithy",
        "TrueMoney **** 3456"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Tep Visal",
        "ABA **** 1111"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Noun Piseth",
        "ACLEDA **** 2222"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Chea Makara",
        "Wing **** 3333"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Ouk Sreypov",
        "ABA **** 4444"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Phan Seyha",
        "TrueMoney **** 5555"
    ),
    FavoriteItem(
        R.drawable.ic_star,
        "Transfer to Keo Ratanak",
        "ACLEDA **** 6666"
    )
)
@Composable
fun FavoriteScreen() {

    val transfer = transferList

    Column(

        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xFFD1D1D1))
            .padding(16.dp)

    ) {
        Text(
            text = "Favorites",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(

        ) {
            items(transfer) { item ->
                Column(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center

                ) {
                    Row(

                        modifier = Modifier
                            .fillMaxWidth(),
                        ) {

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .padding(start = 16.dp),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.White
                            )
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = "Star",
                                tint = Orange40
                            )
                        }

                        Column(

                            modifier = Modifier
                                .padding(start = 16.dp)

                        ) {
                            Text(
                                text = item.transfer
                            )

                            Text(
                                text = item.receiverAccount,
                                fontSize = 12.sp,
                                color = Color.Black.copy(alpha = 0.5f)
                            )
                        }

                    }

                }
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun FavoriteScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        FavoriteScreen()
    }
}