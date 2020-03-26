package com.itesm.pokedex.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itesm.pokedex.interfaces.Pokemon
import com.itesm.pokedex.utils.*

class PokemonMovesListAdapter(private val dataSet: List<Pokemon.MoveWrapper>?) : RecyclerView.Adapter<PokemonMovesListAdapter.ViewHolder>() {
    val LIMIT = 6
    class ViewHolder(v: TextView) : RecyclerView.ViewHolder(v){
        val moveName : TextView = v

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = TextView(parent.context)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(dataSet != null){
            if(dataSet.size > LIMIT){
                return LIMIT
            }
            return dataSet.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataSet != null){
            holder.moveName.text = toTitleCase(snakeToSpace(dataSet[position].move.name))
        }
    }
}