package com.minecraft.launcher

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MinecraftLauncherApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        // Initialize any app-wide configurations here
    }
}