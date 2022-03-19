package com.osisupermoses.pokdexapp.di

import com.osisupermoses.pokdexapp.data.remote.PokeApiService
import com.osisupermoses.pokdexapp.repository.PokemonRepository
import com.osisupermoses.pokdexapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokeApiService) = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokeApi(): PokeApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApiService::class.java)
    }
}