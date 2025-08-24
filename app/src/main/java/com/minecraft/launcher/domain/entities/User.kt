package com.minecraft.launcher.domain.entities

data class User(
    val id: String,
    val username: String,
    val email: String? = null,
    val type: UserType,
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)

enum class UserType {
    MICROSOFT,
    OFFLINE
}