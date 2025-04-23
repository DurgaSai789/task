package com.example.hyderabadtask.ui.schedulepic.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.hyderabadtask.R
import com.example.hyderabadtask.ui.schedulepic.model.ServiceItem
import com.example.hyderabadtask.ui.theme.APP_COLOR
import com.example.hyderabadtask.ui.theme.BOARDER_LINE
import com.example.hyderabadtask.ui.theme.HEX_CODE

@Composable
fun ServiceGrid(gettingTheList: List<ServiceItem>, loading: Boolean) {

    var selectedIndex by remember { mutableIntStateOf(1) }

    val rows = (gettingTheList.size + 2) / 3
    val totalHeight = 120.dp * rows

    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(60.dp)
                    .background(APP_COLOR, shape = CircleShape)
                    .padding(8.dp),
                color = Color.White,
                strokeWidth = 4.dp
            )
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .height(totalHeight)
            .height(100.dp),
        userScrollEnabled = false
    ) {
        items(gettingTheList.size) { index ->
            val item = gettingTheList[index]
            val isSelected = index == selectedIndex

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .clickable { selectedIndex = index }
                    .border(
                        width = if (isSelected) 1.dp else 0.dp,
                        color = if (isSelected) BOARDER_LINE else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(color = HEX_CODE, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {

                    DisplayImage(imageUrl = item.image)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = item.service,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayImage(imageUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        contentDescription = "Image from URL",
        modifier = Modifier.size(50.dp),
        placeholder = painterResource(R.drawable.no_image),
        error = painterResource(R.drawable.no_image)
    )
}
