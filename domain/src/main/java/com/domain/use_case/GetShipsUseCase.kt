package com.domain.use_case

import com.common.Resource
import com.data.network.model.toShips
import com.domain.model.Ships
import com.domain.repository.ShipsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetShipsUseCase @Inject constructor(
    private val repository: ShipsRepository
) {
    operator fun invoke():Flow<Resource<List<Ships>>> = flow {
        try {
            emit(Resource.Loading<List<Ships>>())
            val ships = repository.getAllShips().map{it.toShips()}
            emit(Resource.Success<List<Ships>>(ships))
        }
        catch (e:HttpException){
            emit(Resource.Error<List<Ships>>(e.localizedMessage?:"An unexpected error occurred"))
        }
        catch (e:IOException){
            emit(Resource.Error<List<Ships>>(e.localizedMessage?:"Couldn't reach server. Check your internet connection"))
        }
    }
}


