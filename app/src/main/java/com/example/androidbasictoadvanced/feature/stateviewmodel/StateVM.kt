package com.example.androidbasictoadvanced.feature.stateviewmodel

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.androidbasictoadvanced.feature.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Stable
class StateVM() : ViewModel() {
    private val _userListUiState = MutableStateFlow<MutableList<UserModel>>(mutableStateListOf())
    val userListUiState = _userListUiState.asStateFlow()

    fun save(user: UserModel) {
        val list = userListUiState.value + mutableListOf(user)
        _userListUiState.value = list.toMutableList()
    }

    fun delete(user: UserModel) {
        _userListUiState.value = userListUiState.value.filter { it != user }.toMutableList()
    }
}