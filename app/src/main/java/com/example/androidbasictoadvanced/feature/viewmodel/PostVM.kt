package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasictoadvanced.data.api.RetrofitInstance
import com.example.androidbasictoadvanced.data.model.Post
import com.example.androidbasictoadvanced.data.model.PostUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class PostVM : ViewModel() {

    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    var uiState by mutableStateOf<PostUiState>(
        PostUiState.Loading
    )
        private set

    init {
        fetchPosts()
    }

    // =========================
    // GET - Get all posts
    // =========================
    fun fetchPosts() {

        viewModelScope.launch {

            uiState = PostUiState.Loading

            delay(2000.milliseconds)

            try {

                val result = RetrofitInstance.api.getPosts()

                _posts.value = result

                uiState = PostUiState.Success(result)

            } catch (e: Exception) {

                uiState = PostUiState.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }


    // =========================
    // GET - Get one post
    // =========================
    fun fetchPost(id: Int) {

        viewModelScope.launch {

            try {

                val post = RetrofitInstance.api.getPost(id)

                println("Post: $post")

            } catch (e: Exception) {

                println("Error: ${e.message}")
            }
        }
    }


    // =========================
    // POST - Create post
    // =========================
    fun createPost(
        title: String,
        body: String,
        postId: Int
    ) {

        viewModelScope.launch {

            try {

                val newPost = Post(
                    id = postId,
                    title = title,
                    body = body
                )

                val result = RetrofitInstance.api.createPost(newPost)

                // Add the newly created post to the UI list
                _posts.value += result

                println("Created post: $result")

            } catch (e: Exception) {

                println("Error: ${e.message}")
            }
        }
    }


    // =========================
    // PUT - Replace/update post
    // =========================
    fun updatePost(
        postId: Int,
        title: String,
        body: String,
    ) {

        viewModelScope.launch {

            try {

                val updatedPost = Post(
                    id = postId,
                    title = title,
                    body = body,
                )

                val result =
                    RetrofitInstance.api.updatePost(
                        id = postId,
                        post = updatedPost
                    )

                // Replace the old post in the list
                _posts.value = _posts.value.map { post ->

                    if (post.id == postId) {
                        result
                    } else {
                        post
                    }
                }

                println("Updated post: $result")

            } catch (e: Exception) {

                println("Error: ${e.message}")
            }
        }
    }


    // =========================
    // PATCH - Update part of post
    // =========================
    fun patchPost(
        postId: Int,
        title: String
    ) {

        viewModelScope.launch {

            try {

                val update = mapOf(
                    "title" to title
                )

                val result =
                    RetrofitInstance.api.patchPost(
                        id = postId,
                        post = update
                    )

                // Update the post in the UI
                _posts.value = _posts.value.map { post ->

                    if (post.id == postId) {

                        post.copy(
                            title = result.title
                        )

                    } else {
                        post
                    }
                }

                println("Patched post: $result")

            } catch (e: Exception) {

                println("Error: ${e.message}")
            }
        }
    }


    // =========================
    // DELETE - Delete post
    // =========================
    fun deletePost(postId: Int) {

        viewModelScope.launch {

            try {

                RetrofitInstance.api.deletePost(postId)

                // Remove the post from the UI list
                _posts.value =
                    _posts.value.filter { post ->
                        post.id != postId
                    }

                println("Deleted post: $postId")

            } catch (e: Exception) {

                println("Error: ${e.message}")
            }
        }
    }
}