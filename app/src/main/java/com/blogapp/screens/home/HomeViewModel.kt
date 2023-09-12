package com.blogapp.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.Resource
import com.domain.use_case.GetShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
private val getShipsUseCase: GetShipsUseCase
):ViewModel() {
    private val _state = mutableStateOf(ShipsState())
    val state: State<ShipsState> = _state


    init {
        getShips()
    }

    private fun getShips(){
        getShipsUseCase().onEach {
            result->
            when(result){
                is Resource.Success ->{
                    _state.value = ShipsState(ships = result.data?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = ShipsState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = ShipsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}