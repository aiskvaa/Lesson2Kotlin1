package com.aiskvaa.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aiskvaa.rickandmorty.base.BaseDiffUtil
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import com.example.lesson2kotlin2.databinding.ItemLocationsBinding


class LocationsAdapter  :
    ListAdapter<RickAndMortyLocation, LocationsAdapter.LocationsViewHolder>
        (BaseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class LocationsViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyLocation: RickAndMortyLocation) {
            binding.tvName.text = rickAndMortyLocation.name
            binding.tvType.text = rickAndMortyLocation.type
            binding.tvDimension.text = rickAndMortyLocation.dimension
        }
    }
}





