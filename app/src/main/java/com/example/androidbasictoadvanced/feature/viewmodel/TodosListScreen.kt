package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.data.model.Todos


@Suppress("ParamsComparedByRef")
@Composable
fun TodosListScreen (viewModel: TodosVM) {

    val todo by viewModel.todos

    Scaffold(

    ) {paddingValues ->
        if (todo.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(paddingValues)
            ) {
                items(todo) {
                    TodoCard(it)
                }
            }
        }
    }
}

@Composable
fun TodoCard(todo: Todos) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${todo.id}", color = Color.Black)
            Text(text = todo.title, color = Color.Black)
            Text(text = todo.completed.toString(), color = Color.Black)
        }
    }
}