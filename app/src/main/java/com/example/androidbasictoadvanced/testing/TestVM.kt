package com.example.androidbasictoadvanced.testing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds


class TestVM() : ViewModel() {
    private val _counter = MutableStateFlow(0) // This creates a StateFlow that can be changed.
    val counter = _counter.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000.milliseconds)
                _counter.update { it + 1 }
            }
        }
    }
}