package com.itesm.pokedex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.itesm.pokedex.R
import com.itesm.pokedex.adapters.PokemonListAdapter
import com.itesm.pokedex.utils.PokeApi
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class ActivityPokemonList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        initializeList()
    }
    fun initializeList() {
        // Get all Pokemons
        PokeApi.getPokemons(0,100){
            val list = pokemonList
            val viewManager = LinearLayoutManager(this)
            val viewAdapter = PokemonListAdapter(it)
            list.apply{
                setHasFixedSize(true)

                layoutManager = viewManager
                adapter = viewAdapter
            }
        }

    }
}
