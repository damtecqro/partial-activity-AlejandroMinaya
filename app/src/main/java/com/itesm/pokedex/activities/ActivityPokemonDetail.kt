package com.itesm.pokedex.activities

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.itesm.pokedex.R
import com.itesm.pokedex.adapters.PokemonMovesListAdapter
import com.itesm.pokedex.interfaces.Pokemon
import com.itesm.pokedex.utils.PokeApi
import com.itesm.pokedex.utils.*
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class ActivityPokemonDetail : AppCompatActivity() {
    private val TYPE_BG_COLORS = hashMapOf(
        "NORMAL" to R.color.NORMAL,
        "FIGHTING" to R.color.FIGHTING,
        "FLYING" to R.color.FLYING,
        "POISON" to R.color.POISON,
        "GROUND" to R.color.GROUND,
        "ROCK" to R.color.ROCK,
        "BUG" to R.color.BUG,
        "GHOST" to R.color.GHOST,
        "STEEL" to R.color.STEEL,
        "FIRE" to R.color.FIRE,
        "WATER" to R.color.WATER,
        "GRASS" to R.color.GRASS,
        "ELECTRIC" to R.color.ELECTRIC,
        "PSYCHIC" to R.color.PSYCHIC,
        "ICE" to R.color.ICE,
        "DRAGON" to R.color.DRAGON,
        "DARK" to R.color.DARK,
        "FAIRY" to R.color.FAIRY,
        "UNKNOWN" to R.color.UNKNOWN,
        "SHADOW" to R.color.SHADOW
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializePokemon()
        setContentView(R.layout.activity_pokemon_detail)
    }

    private fun retrieveChosenPokemon() : Bundle?{
        return intent.getBundleExtra("pokemon")
    }

    fun initializePokemon(){
        val pokemonBundle = retrieveChosenPokemon()

        //Retrieve layout members
        if(pokemonBundle != null){
            val pokemonNumber = pokemonBundle.getInt("index")
            PokeApi.getPokemon(pokemonNumber){
                if(it != null){
                    pokemonDetailName.text = toTitleCase(it.name)
                    pokemonDetailNumber.text = prettifyPokemonNumber(it.order)

                    initializeTypes(it.types)
                    initializeStats(it.stats)
                    initializeMoveList(it.moves)
                }
            }
        }
    }

    private fun initializeTypes(types : List<Pokemon.TypeWrapper>){
        pokemonDetailTypes.removeAllViews()
        for(typeWrapper in types){
            val newType = Chip(pokemonDetailTypes.context)
            val typeName = typeWrapper.type.name.toUpperCase()
            newType.text = typeName
            newType.width = WRAP_CONTENT

            @RequiresApi(Build.VERSION_CODES.M)
            newType.chipBackgroundColor = getColorStateList(TYPE_BG_COLORS[typeName] as Int)

            pokemonDetailTypes.addView(newType)
        }
    }

    private fun initializeStats(stats : List<Pokemon.StatWrapper>){
        val table = pokemonDetailStatsTable
        table.removeAllViews()

        for(statWrapper in stats) {
            val tableRow = TableRow(table.context)

            val statName = TextView(table.context)
            statName.text = snakeToSpace(statWrapper.stat.name.toUpperCase())

            val statValue = TextView(table.context)
            statValue.text = statWrapper.base_stat.toString()

            tableRow.addView(statName)
            tableRow.addView(statValue)
            table.addView(tableRow)
        }

    }

    private fun initializeMoveList(moves : List<Pokemon.MoveWrapper>) {
        val list = pokemonDetailMovesList
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = PokemonMovesListAdapter(moves)
        list.apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
