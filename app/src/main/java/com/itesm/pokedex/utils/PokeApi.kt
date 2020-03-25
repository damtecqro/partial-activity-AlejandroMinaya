package com.itesm.pokedex.utils

import android.util.Log
import com.itesm.pokedex.interfaces.Model
import com.itesm.pokedex.interfaces.PokeApiService
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
            callback: (List<Model.PokemonEntry>?) -> Unit) {
            val call = service.getAllPokemon(offset, limit)
            return call.enqueue(object : Callback<Model.Query> {
                override fun onResponse(
                    call: Call<Model.Query>,
                    response: Response<Model.Query>
                ) {
                    Log.d("RETROFIT SUCCESS", response.toString())
                    if (response.code() == 200) {
                        callback(response.body().results);
                    }
                }

                override fun onFailure(call: Call<Model.Query>?, t: Throwable?) {
                    Log.d("RETROFIT FAILURE", t?.toString())
                    callback(null);
                }
            })
        }
    }
}