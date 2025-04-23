package com.example.hyderabadtask.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hyderabadtask.ui.schedulepic.view.SchedulePickupComposable

@Composable
fun NavGraphComposable(
    navHostController: NavHostController,
    innerPadding: PaddingValues,
) {

    NavHost(navController = navHostController, startDestination = SchedulePickUpScreen){
        composable<SchedulePickUpScreen> {
            SchedulePickupComposable(paddingValues = innerPadding)
        }
    }
 }