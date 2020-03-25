package com.itesm.pokedex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itesm.pokedex.R

class ActivityPokemonList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
    }
}
