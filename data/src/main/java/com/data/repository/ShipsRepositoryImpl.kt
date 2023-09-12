package com.data.repository

import com.data.network.ApiService
import com.data.network.model.ShipsDTO
import com.data.network.utils.SafeApiRequest
import com.domain.repository.ShipsRepository
import retrofit2.Response
import javax.inject.Inject

class ShipsRepositoryImpl @Inject constructor(
    private val api: ApiService
):ShipsRepository,SafeApiRequest(){
    override suspend fun getAllShips(): List<ShipsDTO> {
        return api.getShips()
    }
}