package com.aiskvaa.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.aiskvaa.rickandmorty.common.extensions.setImage
import com.aiskvaa.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.ItemCharactersBinding

class CharactersAdapter(
    private val onItemClick: (id: Int) -> Unit)
    : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private var list: List<RickAndMortyCharacter> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =

        CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(list: List<RickAndMortyCharacter>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: RickAndMortyCharacter) {
            binding.imCharacter.setImage(character.image)
            binding.tvCharacter.text = character.name
            binding.tvStatus.text = character.status
            binding.tvSpecies.text = character.species
            binding.tvLastKnownLocation.text = character.location.toString()
            binding.tvFirstLocation.text = character.origin.toString()
            when (character.status) {
                "Alive" -> {
                    binding.imStatus.setImageResource(R.drawable.alive_status)
                }
                "Dead" -> {
                    binding.imStatus.setImageResource(R.drawable.dead_status)
                }
                "Unknown" -> {
                    binding.imStatus.setImageResource(R.drawable.unknown_status)
                }
            }


            binding.root.setOnClickListener {
                onItemClick(character.id)
            }


        }


    }
}
