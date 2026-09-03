package com.example.androidbasictoadvanced.data.api

import com.example.androidbasictoadvanced.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}