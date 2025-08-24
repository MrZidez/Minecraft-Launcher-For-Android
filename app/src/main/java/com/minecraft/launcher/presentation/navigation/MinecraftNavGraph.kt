package com.minecraft.launcher.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minecraft.launcher.presentation.screens.home.HomeScreen
import com.minecraft.launcher.presentation.screens.settings.SettingsScreen
import com.minecraft.launcher.presentation.screens.auth.MicrosoftAuthScreen
import com.minecraft.launcher.presentation.screens.auth.OfflineAccountScreen

@Composable
fun MinecraftNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) },
                onNavigateToMicrosoftAuth = { navController.navigate(Screen.MicrosoftAuth.route) },
                onNavigateToOfflineAccount = { navController.navigate(Screen.OfflineAccount.route) }
            )
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.MicrosoftAuth.route) {
            MicrosoftAuthScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.OfflineAccount.route) {
            OfflineAccountScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}