package com.example.disney.domain.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.disney.databinding.CharacterItemBinding
import com.example.disney.domain.model.Character

class DisneyViewHolder(view: View) : ViewHolder(view) {

    private val binding = CharacterItemBinding.bind(view)

    fun render(item: Character) {
        binding.textViewName.text = item.name
        Glide.with(binding.imageViewCharacter.context).load(item.imageUrl)
            .into(binding.imageViewCharacter)
    }
}
