package com.osisupermoses.pokdexapp.repository

import com.osisupermoses.pokdexapp.data.remote.PokeApiService
import com.osisupermoses.pokdexapp.data.remote.dto.Pokemon
import com.osisupermoses.pokdexapp.data.remote.dto.PokemonList
import com.osisupermoses.pokdexapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository(
    private val api: PokeApiService
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}