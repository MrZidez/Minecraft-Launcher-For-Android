package com.minecraft.launcher.domain.repositories

import com.minecraft.launcher.domain.entities.MinecraftVersion
import kotlinx.coroutines.flow.Flow

interface MinecraftRepository {
    fun getAvailableVersions(): Flow<List<MinecraftVersion>>
    fun getInstalledVersions(): Flow<List<MinecraftVersion>>
    fun downloadVersion(version: MinecraftVersion): Flow<Result<MinecraftVersion>>
    fun installVersion(version: MinecraftVersion): Flow<Result<MinecraftVersion>>
    fun launchVersion(version: MinecraftVersion): Flow<Result<Unit>>
    fun deleteVersion(version: MinecraftVersion): Flow<Result<Unit>>
}