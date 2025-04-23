package com.example.hyderabadtask.data.bottomModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person

object NavRepository {
    suspend fun getNavItems(): List<NavItem> {
        return listOf(
            NavItem(label = "Home", icon = Icons.Default.Home),
            NavItem(label = "Schedule Pickup", icon = Icons.Default.MailOutline),
            NavItem(label = "Rate List", icon = Icons.Default.AccountBox),
            NavItem(label = "My Account", icon = Icons.Default.Person)
        )
    }
}
