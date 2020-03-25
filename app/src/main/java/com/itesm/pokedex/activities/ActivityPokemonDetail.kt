package com.itesm.pokedex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.itesm.pokedex.R
import com.itesm.pokedex.adapters.PokemonMovesListAdapter
import com.itesm.pokedex.utils.PokeApi
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class ActivityPokemonDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
    }

    fun retrieveChosenPokemon() : Bundle?{
        return intent.getBundleExtra("pokemon")
    }

    fun initializeMoveList() {
        val pokemonBundle : Bundle? = retrieveChosenPokemon()
        if(pokemonBundle != null){
            val pokemonNumber = pokemonBundle.getInt("number")
            PokeApi.getPokemon(pokemonNumber){
                val list = pokemonDetailMovesList
                val viewManager = LinearLayoutManager(this)
                val viewAdapter = PokemonMovesListAdapter(it?.moves)
                list.apply{
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }
        }
    }
}
