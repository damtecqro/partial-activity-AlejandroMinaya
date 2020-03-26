package com.itesm.pokedex.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itesm.pokedex.R
import com.itesm.pokedex.activities.ActivityPokemonDetail
import com.itesm.pokedex.interfaces.Pokemons

class PokemonListAdapter(private val dataSet: List<Pokemons.PokemonEntry>?) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var rawPokemonNumber : Int? = null
        val pokemonNumber : TextView = v.findViewById(R.id.pokemonListItemIndex)
        val pokemonName : TextView = v.findViewById(R.id.pokemonListItemName)
        init {
            v.setOnClickListener {
                val pokemonBundle = Bundle()
                if(rawPokemonNumber != null) {
                    pokemonBundle.putInt("index", rawPokemonNumber as Int)
                }
                val intent = Intent(v.context, ActivityPokemonDetail::class.java)
                intent.putExtra("pokemon", pokemonBundle)
                v.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(dataSet != null) {
            return dataSet.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataSet != null) {
            var index = ""
            if (position + 1 < 10) {
                index += "00"
            } else if (position + 1 < 100) {
                index += "0"
            }

            index += (position + 1).toString()
            var name = dataSet[position].name
            name = name[0].toUpperCase() + name.substring(1)

            holder.rawPokemonNumber = position + 1
            holder.pokemonNumber.text = index
            holder.pokemonName.text = name
        }
    }
}