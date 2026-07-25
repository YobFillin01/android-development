package com.example.androidbasictoadvanced.feature.navigationbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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


data class SettingItem(
    val icon: Int,
    val title: String,
    val subTitle: String,
)

val settingList = listOf(
    SettingItem(
        R.drawable.ic_profile,
        "Profile",
        "View Your profile"
    ),

    SettingItem(
        R.drawable.ic_call,
        "Phone Number",
        "+855 XX XXX XXX"
    ),

    SettingItem(
        R.drawable.ic_mail,
        "Email",
        "fillinyob@gmail.com"
    ),

    SettingItem(
        R.drawable.ic_security,
        "Security",
        "PIN, password and biometric"
    ),

)

@Composable
fun SettingScreen() {

    val setting = settingList

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xFFD1D1D1))
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
           modifier = Modifier
               .fillMaxWidth()
               .height(100.dp)
               .clip(RoundedCornerShape(16.dp))
               .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Column(

                modifier = Modifier
                    .padding(start = 16.dp)

            ) {
                Text(
                    text = "Yob Fillin",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = "Second-year student",
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        LazyColumn(



        ) {
            items(setting) {item ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {

                        },

                        modifier = Modifier
                            .padding(16.dp),

                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = "Profile",
                            tint = Color(0xFF2357A8)
                        )
                    }

                    Column(

                        modifier = Modifier

                    ) {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Text(
                            text = item.subTitle,
                            fontSize = 12.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(end = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_forward_arrow),
                            contentDescription = ""
                        )
                    }
                }
            }
        }


    }

}

@Composable
@Preview(showBackground = true)
fun SettingScreenPreview() {
    AndroidBasicToAdvancedTheme() {
        SettingScreen()
    }
}