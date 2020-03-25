package com.itesm.pokedex.interfaces

import retrofit2.Call
import retrofit2.http.*

object Model{
    data class Query(val results : List<PokemonEntry>)
    data class PokemonEntry(val name : String, val url : String)
}
interface PokeApiService {
    @GET("pokemon")
    fun getAllPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Call<Model.Query>
}
