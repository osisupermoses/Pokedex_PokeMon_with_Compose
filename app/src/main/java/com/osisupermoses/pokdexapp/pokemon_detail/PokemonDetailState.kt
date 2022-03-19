package com.osisupermoses.pokdexapp.pokemon_detail

import com.osisupermoses.pokdexapp.data.remote.dto.Pokemon

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon:Pokemon? = null,
    val error: String = ""
)
