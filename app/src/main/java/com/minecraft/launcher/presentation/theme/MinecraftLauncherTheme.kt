package com.minecraft.launcher.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = MinecraftColors.Green,
    onPrimary = MinecraftColors.White,
    primaryContainer = MinecraftColors.LightGreen,
    onPrimaryContainer = MinecraftColors.DarkGreen,
    secondary = MinecraftColors.Brown,
    onSecondary = MinecraftColors.White,
    secondaryContainer = MinecraftColors.LightGray,
    onSecondaryContainer = MinecraftColors.DarkBrown,
    tertiary = MinecraftColors.Orange,
    onTertiary = MinecraftColors.White,
    tertiaryContainer = MinecraftColors.Yellow,
    onTertiaryContainer = MinecraftColors.DarkBrown,
    error = MinecraftColors.Red,
    onError = MinecraftColors.White,
    errorContainer = MinecraftColors.ErrorContainer,
    onErrorContainer = MinecraftColors.OnErrorContainer,
    background = MinecraftColors.White,
    onBackground = MinecraftColors.Black,
    surface = MinecraftColors.White,
    onSurface = MinecraftColors.Black,
    surfaceVariant = MinecraftColors.LightGray,
    onSurfaceVariant = MinecraftColors.DarkGray,
    outline = MinecraftColors.Gray,
    outlineVariant = MinecraftColors.LightGray,
    inverseOnSurface = MinecraftColors.LightGray,
    inverseSurface = MinecraftColors.DarkGray,
    inversePrimary = MinecraftColors.LightGreen,
    shadow = MinecraftColors.Black,
    scrim = MinecraftColors.Black
)

private val DarkColorScheme = darkColorScheme(
    primary = MinecraftColors.Green,
    onPrimary = MinecraftColors.Black,
    primaryContainer = MinecraftColors.DarkGreen,
    onPrimaryContainer = MinecraftColors.LightGreen,
    secondary = MinecraftColors.DarkBrown,
    onSecondary = MinecraftColors.White,
    secondaryContainer = MinecraftColors.Brown,
    onSecondaryContainer = MinecraftColors.LightGray,
    tertiary = MinecraftColors.DarkBrown,
    onTertiary = MinecraftColors.White,
    tertiaryContainer = MinecraftColors.Brown,
    onTertiaryContainer = MinecraftColors.Yellow,
    error = MinecraftColors.Red,
    onError = MinecraftColors.Black,
    errorContainer = MinecraftColors.ErrorContainer,
    onErrorContainer = MinecraftColors.OnErrorContainer,
    background = MinecraftColors.Black,
    onBackground = MinecraftColors.White,
    surface = MinecraftColors.Black,
    onSurface = MinecraftColors.White,
    surfaceVariant = MinecraftColors.DarkGray,
    onSurfaceVariant = MinecraftColors.LightGray,
    outline = MinecraftColors.Gray,
    outlineVariant = MinecraftColors.DarkGray,
    inverseOnSurface = MinecraftColors.DarkGray,
    inverseSurface = MinecraftColors.LightGray,
    inversePrimary = MinecraftColors.DarkGreen,
    shadow = MinecraftColors.Black,
    scrim = MinecraftColors.Black
)

@Composable
fun MinecraftLauncherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}