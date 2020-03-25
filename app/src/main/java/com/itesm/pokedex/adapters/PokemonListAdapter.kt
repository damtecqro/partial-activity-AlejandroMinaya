package com.itesm.pokedex.adapters

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itesm.pokedex.R
import com.itesm.pokedex.interfaces.Model

class PokemonListAdapter(private val dataSet: List<Model.PokemonEntry>?) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val pokemonIndex : TextView = v.findViewById(R.id.pokemonListItemIndex)
        val pokemonName : TextView = v.findViewById(R.id.pokemonListItemName)
        init {
            v.setOnClickListener {  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        if(dataSet != null) {
            return dataSet.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataSet != null) {
            var index = "#"
            if (position + 1 < 10) {
                index += "00"
            } else if (position + 1 < 100) {
                index += "0"
            }

            index += (position + 1).toString()

            holder.pokemonIndex.text = index;
            holder.pokemonName.text = dataSet[position].name
        }
    }
}