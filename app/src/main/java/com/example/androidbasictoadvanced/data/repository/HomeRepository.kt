package com.example.androidbasictoadvanced.data.repository

import com.example.androidbasictoadvanced.navigation.ComponentItem
import com.example.androidbasictoadvanced.navigation.componentsList
import com.example.androidbasictoadvanced.util.BaseUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds


class HomeRepository {

     fun getHomeData(): Flow<BaseUiState<List<ComponentItem>>> {
        return flow {
            emit(BaseUiState.Loading)
            delay(1000.milliseconds)
            emit(BaseUiState.Success(componentsList))
        }
    }

}