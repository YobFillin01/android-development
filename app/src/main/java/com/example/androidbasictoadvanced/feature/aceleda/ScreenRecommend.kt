package com.example.androidbasictoadvanced.feature.aceleda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import kotlinx.coroutines.delay

@Composable
fun ScreenRecommend() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {

        val recommendImage = listOf(
            R.drawable.img_aceleda_recommended1,
            R.drawable.img_aceleda_recommended2,
            R.drawable.img_aceleda_recommended3
        )

        val tourismImage = listOf(
            R.drawable.img_baksei_jamkrong_temple,
            R.drawable.img_sambor_prei_kok_temple,
            R.drawable.img_pnhum_kulen
        )



        val pagerState1 = rememberPagerState(
            initialPage = 0,
            pageCount = { recommendImage.size }
        )

        val pagerState2 = rememberPagerState(
            initialPage = 0,
            pageCount = { tourismImage.size }
        )

        // Auto slide every 3 seconds
        LaunchedEffect(Unit) {
            while (true) {
                delay(2000)

                val nextPage =
                    (pagerState1.currentPage + 1) % recommendImage.size

                pagerState1.animateScrollToPage(nextPage)
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(2000)

                val nextPage =
                    (pagerState2.currentPage + 1) % tourismImage.size

                pagerState2.animateScrollToPage(nextPage)
            }
        }

        Text(
            text = "Recommended",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            state = pagerState1,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .height(200.dp)
        ) { page ->

            Image(
                painter = painterResource(recommendImage[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cambodia Tourism",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Icon(
                painter = painterResource(R.drawable.ic_forward_arrow),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            state = pagerState2,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .height(200.dp)
        ) { page ->

            Image(
                painter = painterResource(tourismImage[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

    }

}

@Composable
@Preview(showBackground = true)
fun ScreenRecommendPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenRecommend()
    }
}