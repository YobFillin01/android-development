package com.example.androidbasictoadvanced.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasictoadvanced.data.repository.HomeRepository
import com.example.androidbasictoadvanced.util.BaseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {

    private val _stateUiState = MutableStateFlow<BaseUiState<List<ComponentItem>>>(BaseUiState.None)
    val stateUiState = _stateUiState.asStateFlow()

//    fun fetchComponentList() {
//        viewModelScope.launch {
//            _stateUiState.emit(BaseUiState.Loading)
//            delay(1000.milliseconds)
//            _stateUiState.emit(BaseUiState.Success(componentsList))
////            _stateUiState.emit(BaseUiState.Failure(code = "404", message = "Not Found"))
////            _stateUiState.emit(BaseUiState.Exception(throwable = Exception("Exception")))
//        }
//    }

    init {
        getHomeData()
    }

    fun getHomeData() {
        viewModelScope.launch {
            homeRepository.getHomeData().collect { componentListUiState ->
                println("=====> Test $componentListUiState")
                _stateUiState.emit(componentListUiState)
            }
        }
    }

}