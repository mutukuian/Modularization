package com.domain.repository

import com.data.network.model.ShipsDTO
import com.domain.model.Ships
import retrofit2.Response

interface ShipsRepository {
    suspend fun getAllShips():List<ShipsDTO>
}