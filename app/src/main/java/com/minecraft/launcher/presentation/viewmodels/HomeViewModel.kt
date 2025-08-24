package com.minecraft.launcher.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minecraft.launcher.domain.entities.MinecraftVersion
import com.minecraft.launcher.domain.repositories.MinecraftRepository
import com.minecraft.launcher.domain.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val minecraftRepository: MinecraftRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        loadData()
    }
    
    private fun loadData() {
        viewModelScope.launch {
            combine(
                minecraftRepository.getAvailableVersions(),
                minecraftRepository.getInstalledVersions(),
                userRepository.getCurrentUser()
            ) { availableVersions, installedVersions, currentUser ->
                Triple(availableVersions, installedVersions, currentUser)
            }.collect { (available, installed, user) ->
                _uiState.value = _uiState.value.copy(
                    availableVersions = available,
                    installedVersions = installed,
                    currentUser = user,
                    isLoading = false
                )
            }
        }
    }
    
    fun onVersionSelected(version: MinecraftVersion) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(selectedVersion = version)
        }
    }
    
    fun launchGame() {
        val selectedVersion = _uiState.value.selectedVersion ?: return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLaunching = true)
            
            minecraftRepository.launchVersion(selectedVersion)
                .onSuccess {
                    _uiState.value = _uiState.value.copy(isLaunching = false)
                }
                .onFailure { error ->
                    _uiState.value = _uiState.value.copy(
                        isLaunching = false,
                        error = error.message
                    )
                }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class HomeUiState(
    val availableVersions: List<MinecraftVersion> = emptyList(),
    val installedVersions: List<MinecraftVersion> = emptyList(),
    val selectedVersion: MinecraftVersion? = null,
    val currentUser: com.minecraft.launcher.domain.entities.User? = null,
    val isLoading: Boolean = true,
    val isLaunching: Boolean = false,
    val error: String? = null
)