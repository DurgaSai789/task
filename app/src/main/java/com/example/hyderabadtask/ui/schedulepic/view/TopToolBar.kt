package com.example.hyderabadtask.ui.schedulepic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.hyderabadtask.ui.theme.BELL_ICON_COLOR

@PreviewScreenSizes
@Composable
fun TopToolBar() {

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {

                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val (titleText, taglineText) = createRefs()

                    Text(
                        text = "sparkles",
                        color = Color(0xFF0071BC),
                        fontSize = 47.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(titleText) {
                                start.linkTo(parent.start)
                            }
                    )

                    Text(
                        text = "THE REAL CLEANERS & LAUNDERERS",
                        color = Color.Black,
                        fontSize = 6.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.constrainAs(taglineText) {
                            start.linkTo(titleText.start)
                            top.linkTo(titleText.bottom, margin = -10.dp)
                            end.linkTo(titleText.end)
                        }
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )

                    Text(
                        text = "Sri Sai Nagar, Madhapur",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

            Box(modifier = Modifier.size(68.dp)) {

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),

                    ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = BELL_ICON_COLOR
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(all = 18.dp)
                        .align(Alignment.TopEnd)
                        .size(12.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Black,
                            shape = CircleShape
                        )
                        .background(Color.Red, shape = CircleShape),
                )
            }
        }
    }
}
