package com.example.androidbasictoadvanced.vetexpress

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.delay

@Composable
fun ScreenVEt() {

    val bottom = bottomList

    var selectedIndex by remember { mutableIntStateOf(0) }



    Scaffold(

        containerColor = Color.LightGray.copy(alpha = 0.5f),

        topBar = {

            TopAppBar(

                title = {
                    Text(
                        text = "VET Express",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.img_vet_express),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                    )
                },

                actions = {

                    Image(
                        painter = painterResource(R.drawable.img_cam_flag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                    )

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_chat),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF6200),
                    titleContentColor = Color.White
                )
            )
        },

        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    bottom.forEachIndexed { index, bottom ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            IconButton(
                                onClick = {
                                    selectedIndex = index
                                },

                                ) {
                                Icon(
                                    imageVector = if (selectedIndex == index) {
                                        bottom.filledIcon
                                    } else {
                                        bottom.outlinedIcon
                                    },
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp),
                                    tint = if (selectedIndex == index) {
                                        Color(0xFFFF6200)
                                    } else {
                                        Color.Gray
                                    }
                                )
                            }

                            Text(
                                text = bottom.title ?: "",
                                fontSize = 12.sp,
                                color = if (selectedIndex == index) {
                                    Color(0xFFFF6200)
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                    }

                }
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Profile()

            Booking()

            Text(
                text = "Another Services",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            AnotherService()

            Text(
                text = "Accommodation",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Accommodation()

            Text(
                text = "Notification and Promotion",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            NotificationAndPromotion()
        }
    }
}

@Composable
fun NotificationAndPromotion() {

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val images = listOf(
            R.drawable.img_vet_promo1,
            R.drawable.img_vet_promo2,
            R.drawable.img_vet_promo3,
            R.drawable.img_vet_promo4
        )

        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { images.size }
        )

        // Auto slide every 3 seconds
        LaunchedEffect(Unit) {
            while (true) {
                delay(3000)

                val nextPage =
                    (pagerState.currentPage + 1) % images.size

                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = 1000
                    )
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .height(150.dp)
        ) { page ->
            Image(
                painter = painterResource(images[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }


    }

}

@Composable
fun Accommodation() {

    val accommodation = accommodationList

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp)
            .horizontalScroll(scrollState)

    ) {

        accommodation.forEach { accommodation ->

            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(210.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                Column(

                    verticalArrangement = Arrangement.SpaceBetween

                ) {

                    Box {
                        Image(
                            painter = painterResource(accommodation.image),
                            contentDescription = null
                        )

                        Text(
                            text = accommodation.title,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp)
                        )
                    }


                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = accommodation.price,
                            color = Color(0xFFFF6200)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF6200).copy(alpha = 0.2f),
                                contentColor = Color(0xFFFF6200)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(width = 1.dp, color = Color(0xFFFF6200))
                        ) {
                            Text(
                                text = "Booking now",
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun AnotherService() {

    val services = serviceList

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 8.dp)
    ) {

        services.forEach { service ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .width(200.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = service.icon,
                        contentDescription = null,
                        tint = Color(0xFFFF6200),
                        modifier = Modifier.size(32.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = service.text
                    )
                }
            }
        }
    }
}

// Fix booking. Change verticalGrid to Box instead.

@Composable
fun Booking() {

    val row1 = boxesList1
    val row2 = boxesList2

    Column(
        modifier = Modifier
            .padding(16.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            row1.forEach { row1 ->
                Box(
                    modifier = Modifier
                        .size(
                            width = 120.dp,
                            height = 110.dp
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(row1.image),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )

                        Text(
                            text = row1.text,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                        )

                    }
                }
            }

        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            row2.forEach { row2 ->
                Box(
                    modifier = Modifier
                        .size(
                            width = 120.dp,
                            height = 110.dp
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(row2.image),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )

                        Text(
                            text = row2.text,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Profile() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(

                modifier = Modifier
                    .clip(CircleShape)

            ) {
                Image(
                    painter = painterResource(R.drawable.img_my_picture),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Hello, Fillin",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = "View Account",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }

}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenVETPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenVEt()
    }
}