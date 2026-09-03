package com.example.androidbasictoadvanced.data.model


sealed interface PostUiState {

    data object Loading : PostUiState

    data class Success(
        val posts: List<Post>
    ) : PostUiState

    data class Error(
        val message: String
    ) : PostUiState

}