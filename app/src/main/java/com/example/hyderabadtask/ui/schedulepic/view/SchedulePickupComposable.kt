package com.example.hyderabadtask.ui.schedulepic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hyderabadtask.ui.schedulepic.viewModel.SchedulePickupViewModel
import com.example.hyderabadtask.ui.theme.APP_COLOR

@Composable
fun SchedulePickupComposable(
    mViewModel: SchedulePickupViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {

    mViewModel.getDetails()
    val gettingTheList by mViewModel.transactions.collectAsState()
    val loading by mViewModel.loading.collectAsState()

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color.White)
            .padding(paddingValues)
    ) {

        TopToolBar()
        Spacer(modifier = Modifier.height(5.dp))
        ImageSlider(modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        FaqComposable()
        Spacer(modifier = Modifier.height(10.dp))
        SelectServices()
        ServiceGrid(gettingTheList, loading)
        Spacer(modifier = Modifier.height(10.dp))
        ScheduleComposable()
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun ScheduleComposable() {

    Column(
        modifier = Modifier
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 16.dp)
                .background(color = APP_COLOR),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SCHEDULE PICKUP",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
