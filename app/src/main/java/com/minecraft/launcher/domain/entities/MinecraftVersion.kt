package com.minecraft.launcher.domain.entities

data class MinecraftVersion(
    val id: String,
    val name: String,
    val type: VersionType,
    val version: String,
    val releaseDate: Long,
    val isInstalled: Boolean = false,
    val downloadUrl: String? = null,
    val size: Long = 0,
    val description: String = ""
)

enum class VersionType {
    JAVA_EDITION,
    BEDROCK_EDITION
}