package com.osisupermoses.pokdexapp.data.remote.dto

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)