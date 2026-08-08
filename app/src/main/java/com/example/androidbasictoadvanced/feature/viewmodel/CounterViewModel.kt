package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CounterViewModel : ViewModel() {
    var count by mutableIntStateOf(0)
        /**
         * private set means Other classes can read count,
         * but only CounterViewModel can change count.
         */
        private set

    fun increase() {
        count ++
    }
}