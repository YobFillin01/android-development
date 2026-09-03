package com.example.androidbasictoadvanced.data.api

import com.example.androidbasictoadvanced.data.model.Todos
import retrofit2.http.GET

interface ApiService2 {
    @GET("todos")
    suspend fun getTodos(): List<Todos>
}