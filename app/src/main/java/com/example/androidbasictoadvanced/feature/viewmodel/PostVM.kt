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

class PostVM: ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    var uiState by mutableStateOf<PostUiState>(
        PostUiState.Loading
    )

        private set

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {

            uiState = PostUiState.Loading
            delay(3000.milliseconds)

            try {
                _posts.value = RetrofitInstance.api.getPosts()
                uiState = PostUiState.Success(_posts.value)

            } catch (e: Exception) {
                uiState = PostUiState.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }

}