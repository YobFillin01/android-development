package com.example.androidbasictoadvanced.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM : ViewModel() {

    private val _state = MutableStateFlow<List<ComponentItem>?>(null)
    val state = _state.asStateFlow()

    fun fetchComponentList() {

        viewModelScope.launch {
            _state.emit(componentsList)
        }

    }

}