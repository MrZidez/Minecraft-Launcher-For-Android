package com.minecraft.launcher.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Settings : Screen("settings")
    object MicrosoftAuth : Screen("microsoft_auth")
    object OfflineAccount : Screen("offline_account")
}