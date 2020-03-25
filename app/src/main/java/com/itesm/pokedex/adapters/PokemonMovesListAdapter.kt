package com.itesm.pokedex.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonMovesListAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<PokemonMovesListAdapter.ViewHolder>() {
    class ViewHolder(v: TextView) : RecyclerView.ViewHolder(v){
        val moveName : TextView = v

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = TextView(parent.context)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.moveName.text = dataSet[position]
    }
}