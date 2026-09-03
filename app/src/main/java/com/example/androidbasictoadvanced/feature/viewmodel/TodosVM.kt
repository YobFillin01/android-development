package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasictoadvanced.data.api.RetrofitInstance2
import com.example.androidbasictoadvanced.data.model.Todos
import kotlinx.coroutines.launch

class TodosVM: ViewModel() {
    private val _todos = mutableStateOf<List<Todos>>(emptyList())
    val todos: State<List<Todos>> = _todos

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                _todos.value = RetrofitInstance2.api.getTodos()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}