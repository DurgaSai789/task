package com.example.hyderabadtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.hyderabadtask.data.bottomModel.NavItem
import com.example.hyderabadtask.data.bottomModel.NavRepository
import com.example.hyderabadtask.navigation.NavGraphComposable
import com.example.hyderabadtask.ui.theme.APP_COLOR
import com.example.hyderabadtask.ui.theme.HyderabadTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            HyderabadTaskTheme {
                var navItems by remember { mutableStateOf<List<NavItem>>(emptyList()) }

                LaunchedEffect(Unit) {
                    navItems = NavRepository.getNavItems()
                }

                var selectIndex by remember { mutableIntStateOf(1) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (navItems.isNotEmpty()) {
                            Column {
                                Divider(color = APP_COLOR, thickness = 0.5.dp)
                                NavigationBar(containerColor = Color.White) {
                                    navItems.forEachIndexed { index, item ->
                                        val isSelected = selectIndex == index
                                        NavigationBarItem(
                                            selected = isSelected,
                                            onClick = { selectIndex = index },
                                            icon = {
                                                Icon(
                                                    imageVector = item.icon,
                                                    contentDescription = null,
                                                    tint = APP_COLOR,
                                                    modifier = Modifier.size(if (isSelected) 26.dp else 22.dp)
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = item.label,
                                                    color = APP_COLOR,
                                                    textAlign = TextAlign.Center,
                                                    maxLines = 1,
                                                    fontSize = if (isSelected) 10.sp else 8.sp,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            },
                                            colors = NavigationBarItemDefaults.colors(
                                                selectedIconColor = APP_COLOR,
                                                unselectedIconColor = APP_COLOR,
                                                selectedTextColor = APP_COLOR,
                                                unselectedTextColor = APP_COLOR,
                                                indicatorColor = Color.Transparent
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->

                    if (selectIndex == 1) {
                        val navController = rememberNavController()
                        NavGraphComposable(navController, innerPadding)
                    } else {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {

                            Text("No Data Available",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

