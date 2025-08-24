package com.minecraft.launcher.domain.repositories

import com.minecraft.launcher.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getCurrentUser(): Flow<User?>
    fun signInMicrosoft(email: String, password: String): Flow<Result<User>>
    fun createOfflineAccount(username: String, password: String): Flow<Result<User>>
    fun signOut(): Flow<Result<Unit>>
    fun deleteUser(userId: String): Flow<Result<Unit>>
}