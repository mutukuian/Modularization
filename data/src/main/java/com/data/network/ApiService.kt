package com.data.network


import com.data.network.model.ShipsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/ships")
    suspend fun getShips():List<ShipsDTO>
}