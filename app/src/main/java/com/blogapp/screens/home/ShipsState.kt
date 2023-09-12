package com.blogapp.screens.home

import com.domain.model.Ships

data class ShipsState(
    val isLoading:Boolean = false,
    val ships:List<Ships> = emptyList(),
    val error:String = ""
)
