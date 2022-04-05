package com.aiskvaa.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aiskvaa.rickandmorty.base.BaseDiffUtil
import com.aiskvaa.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.example.lesson2kotlin2.databinding.ItemEpisodesBinding

class EpisodesAdapter :
    ListAdapter<RickAndMortyEpisode, EpisodesAdapter.EpisodeViewHolder>(BaseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyEpisode: RickAndMortyEpisode) {

            binding.tvName.text = rickAndMortyEpisode.name
            binding.tvAirDate.text = rickAndMortyEpisode.air_date
            binding.tvEpisode.text = rickAndMortyEpisode.episode


        }
    }
}


