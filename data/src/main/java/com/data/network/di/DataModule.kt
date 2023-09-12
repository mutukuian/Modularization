package com.data.network.di

import com.common.Constants
import com.data.network.ApiService
import com.data.repository.ShipsRepositoryImpl
import com.domain.repository.ShipsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesApiService():ApiService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    fun providesShipsRepository(api:ApiService):ShipsRepository{
        return ShipsRepositoryImpl(api)
    }
}