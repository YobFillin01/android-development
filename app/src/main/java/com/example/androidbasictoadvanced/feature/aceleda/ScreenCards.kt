package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Indigo40
import com.example.androidbasictoadvanced.ui.theme.Indigo80


@Composable
fun ScreenCards(
    onBack:() -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF0D3157))
            .fillMaxSize()
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
                text = "Cards",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_acc_wallet),
                contentDescription = "Card",
                modifier = Modifier.size(110.dp),
                tint = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                ))
                .background(Color.White)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            ElevatedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(150.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(32.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF0097A7),
                                        Color(0xFF0288D1)
                                    )
                                )
                            )
                    ) { }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(  horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Plastic Debit Cards",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D3157)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = """
                                All card transactions are debited from 
                                the cardholder's ACELEDA Bank account.
                            """.trimIndent(),
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        HorizontalDivider()

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "VISA",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xFF0D3157)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                painter = painterResource(R.drawable.ic_profession),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_acc_wallet),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_users),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(
                                onClick = {}
                            ) {
                                Text(
                                    text = "Add Now",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0288D1)
                                )
                            }
                        }
                    }
                }
            }

            ElevatedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(150.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(32.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Black,
                                        Color.Green
                                    )
                                )
                            )
                    ) { }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(  horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Virtual Debit Cards",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D3157)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = """
                                Use it for online purchases. subscriptions, and other payments
                            """.trimIndent(),
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        HorizontalDivider()

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "VISA",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xFF0D3157)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                painter = painterResource(R.drawable.ic_profession),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_acc_wallet),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_users),
                                contentDescription = null,
                                tint = Color(0xFF0D3157)
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(
                                onClick = {}
                            ) {
                                Text(
                                    text = "Add Now",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0288D1)
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
fun ScreenCardsPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenCards {}
    }
}