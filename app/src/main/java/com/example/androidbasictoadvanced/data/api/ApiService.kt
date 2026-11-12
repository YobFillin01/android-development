package com.example.androidbasictoadvanced.data.api

import com.example.androidbasictoadvanced.data.model.Post
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    // GET one post
    @GET("posts/{id}")
    suspend fun getPost(
        @Path("id") id: Int
    ): Post

    // POST
    @POST("posts")
    suspend fun createPost(
        @Body post: Post
    ): Post

    // PUT
    @PUT("posts/{id}")
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body post: Post
    ): Post

    // PATCH
    @PATCH("posts/{id}")
    suspend fun patchPost(
        @Path("id") id: Int,
        @Body post: Map<String, String>
    ): Post

    // DELETE
    @DELETE("posts/{id}")
    suspend fun deletePost(
        @Path("id") id: Int
    )
}