package com.example.androidbasictoadvanced.feature.aceleda

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


val paymentList = listOf(
    DataModel(
        R.drawable.ic_users,
        "Membership",
        "Pay for memberships and",
        "subscriptions",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_mobile,
        "Mobile Operator",
        description1 = "Pay to mobile operator",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_bills,
        "Pending Payments",
        "Payment waiting lists",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_transfer,
        "Private Solid Waste Bill",
        "Pay for private solid waste bills",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_public,
        "Public Services",
        "Pay for all taxes and",
        "public services",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_account_balance,
        "Real Estate",
        "Pay for land and buildings",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_school,
        "School",
        "Pay for university and",
        "school fees",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_loans,
        "Charity & Donation",
        "Donate to hospitals, schools, or",
        "charitable organizations",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_finance_mode,
        "Derivatives Brokers Payment",
        "Deposit to Derivative",
        "Trading Account",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_shop,
        "E-commerce",
        "Pay for online purchases",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_mobile,
        "Entertainment",
        description1 = null,
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_account_balance,
        "Financial & Investment",
        "Pay for ACLEDA Credit Card or",
        "other financial service bills",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_insurance,
        "Insurance",
        "Pay premiums to insurance",
        "companies for your protection",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_television,
        "Internet & TV",
        "Pay for Internet and TV",
        "service bills",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_timer,
        "Auto Payment",
        "Auto payment for electricity",
        "and insurance",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_water,
        "Water Supply",
        "Pay for PPWSA and private",
        "water supply bills",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_activity,
        "Electricity",
        "Pay for EDC and private",
        "electricity bills",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_profession,
        "Enterprise for Managing Municipal Solid Waste",
        "Pay for enterprise for managing",
        "municipal solid waste in Phnom Penh",
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_deposit,
        "Agriculture",
        "Pay to agricultural companies",
        description2 = null,
        R.drawable.ic_arrow_right
    ),

    DataModel(
        R.drawable.ic_coin,
        "Bill 24 General",
        "Pay to B24",
        description2 = null,
        R.drawable.ic_arrow_right
    )
)

@Composable
fun ScreenPayment(
    onBack:() -> Unit
) {

    val payments = paymentList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF0D3157))
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
                text = "Payment",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        payments.forEachIndexed { _, item ->

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White),
                verticalArrangement = Arrangement.Center
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(item.leadingIcon),
                        contentDescription = null,
                        tint = Color(0xFF0D3157),
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(16.dp))
//                            .background(Color(0xFF382647))
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    VerticalDivider()

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(

                    ) {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D3157),
                        )

                        item.description1?.let {
                            Text(
                                text = it,
                                color = Color.Gray
                            )
                        }

                        item.description2?.let {
                            Text(
                                text = it,
                                color = Color.Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Color(0xFFBF9A33),
                        modifier = Modifier.size(40.dp)
                    )

                }
            }
        }


    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenPaymentPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenPayment {}
    }
}