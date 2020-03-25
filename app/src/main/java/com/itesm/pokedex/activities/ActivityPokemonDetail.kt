package com.itesm.pokedex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.itesm.pokedex.R
import com.itesm.pokedex.adapters.PokemonMovesListAdapter
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class ActivityPokemonDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
    }

    fun initializeMoveList() {
        val list = pokemonDetailMovesList
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = PokemonMovesListAdapter(null)
        list.apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
