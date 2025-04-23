package com.example.hyderabadtask.ui.schedulepic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hyderabadtask.ui.schedulepic.model.HowDoes
import com.example.hyderabadtask.ui.schedulepic.model.HowDoesRepository
import com.example.hyderabadtask.ui.theme.HOW_DOES_BACKGROUND

@Composable
fun FaqComposable() {

    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = HOW_DOES_BACKGROUND),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
    ) {

        Column(modifier = Modifier.padding(vertical = 12.dp)) {
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "HOW DOES THIS APP WORK",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            StepsRow()
        }
    }
}

@Composable
fun StepsRow() {

    var items by remember { mutableStateOf<List<HowDoes>>(emptyList()) }

    LaunchedEffect(Unit) {
        items = HowDoesRepository().getHowDoesItems()
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(items.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = items[index].image),
                    contentDescription = items[index].imageName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(44.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = items[index].imageName,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
