package com.itesm.pokedex.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itesm.pokedex.interfaces.Pokemon

class PokemonMovesListAdapter(private val dataSet: List<Pokemon.MoveWrapper>?) : RecyclerView.Adapter<PokemonMovesListAdapter.ViewHolder>() {
    class ViewHolder(v: TextView) : RecyclerView.ViewHolder(v){
        val moveName : TextView = v

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = TextView(parent.context)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(dataSet != null){
            return dataSet.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataSet != null){
            holder.moveName.text = dataSet[position].move.name
        }
    }
}