package com.itesm.pokedex.interfaces

import retrofit2.Call
import retrofit2.http.*

/* OBJECTS */
object Pokemons{
    data class PokemonEntry(val name : String, val url : String)
    data class Query(val results : List<PokemonEntry>)
}
object Pokemon {
    data class Type(val name : String, val url : String)
    data class TypeWrapper(val type : Type, val slot : Int)
    data class Stat(val name : String, val url : String)
    data class StatWrapper(val stat : Stat, val base_stat : Int)
    data class Move(val name : String, val url : String)
    data class MoveWrapper(val move : Move)
    data class Sprites(
        val front_default : String
    )
    data class Query(
        val moves : List<MoveWrapper>,
        val stats : List<StatWrapper>,
        val types : List<TypeWrapper>,
        val name : String,
        val order : Int,
        val sprites : Sprites
    )
}

/* API CALLS */
interface PokeApiService {
    @GET("pokemon")
    fun getAllPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Call<Pokemons.Query>

    @GET("pokemon/{id}")
    fun getPokemon(
        @Path("id") id : Int
    ) : Call<Pokemon.Query>
}
