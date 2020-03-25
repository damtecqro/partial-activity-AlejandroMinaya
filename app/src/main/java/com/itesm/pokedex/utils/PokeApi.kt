package com.itesm.pokedex.utils

import android.util.Log
import com.itesm.pokedex.interfaces.Pokemons
import com.itesm.pokedex.interfaces.PokeApiService
import com.itesm.pokedex.interfaces.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeApi {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PokeApiService::class.java)

        fun getPokemons(
            offset: Int,
            limit: Int,
            callback: (List<Pokemons.PokemonEntry>?) -> Unit) {
            val call = service.getAllPokemon(offset, limit)
            return call.enqueue(object : Callback<Pokemons.Query> {
                override fun onResponse(
                    call: Call<Pokemons.Query>,
                    response: Response<Pokemons.Query>
                ) {
                    Log.d("RETROFIT SUCCESS", response.toString())
                    if (response.code() == 200) {
                        callback(response.body().results);
                    }
                }

                override fun onFailure(call: Call<Pokemons.Query>?, t: Throwable?) {
                    Log.d("RETROFIT FAILURE", t?.toString())
                    callback(null);
                }
            })
        }

        fun getPokemon(
            number: Int,
            callback: (Pokemon.Query?) -> Unit){
            val call = service.getPokemon(number)
            return call.enqueue(object : Callback<Pokemon.Query> {
                override fun onResponse(
                    call: Call<Pokemon.Query>?,
                    response: Response<Pokemon.Query>
                ) {
                    Log.d("RETROFIT SUCCESS", response.toString())
                    if (response.code() == 200) {
                        callback(response.body());
                    }
                }

                override fun onFailure(call: Call<Pokemon.Query>?, t: Throwable?) {
                    Log.d("RETROFIT FAILURE", t?.toString())
                    callback(null);
                }

            })

        }
    }
}