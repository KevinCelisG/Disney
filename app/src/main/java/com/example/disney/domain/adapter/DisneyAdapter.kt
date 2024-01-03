package com.example.disney.domain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.disney.R
import com.example.disney.domain.model.Character

class DisneyAdapter(private var disneyCharacters: List<Character>) : Adapter<DisneyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return DisneyViewHolder(layoutInflater.inflate(R.layout.character_item, parent, false))
    }

    override fun onBindViewHolder(holder: DisneyViewHolder, position: Int) {
        var item = disneyCharacters[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = disneyCharacters.size

    fun setDisneyCharacters(disneyCharacters: List<Character>) {
        this.disneyCharacters = disneyCharacters
    }
}