package com.example.hyderabadtask.ui.schedulepic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hyderabadtask.R
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@Composable
fun ImageSlider(modifier: Modifier) {

    val imageList = listOf(
        R.drawable.sliderone,
        R.drawable.slidertwo,
        R.drawable.sliderthree
    )

    val pagerState = rememberPagerState()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.8f)
    ) {
        HorizontalPager(
            count = imageList.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = imageList[page]),
                contentDescription = "Slider Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = Color(0xFF0071BC),
            inactiveColor = Color.LightGray,
            indicatorWidth = 8.dp,
            spacing = 6.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        )
    }
}
