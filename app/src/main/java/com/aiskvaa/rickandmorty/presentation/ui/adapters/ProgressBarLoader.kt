package com.aiskvaa.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2kotlin2.databinding.ProgressBarLoaderBinding

class ProgressBarLoader(private val retry : () -> Unit) : LoadStateAdapter<ProgressBarLoader.LoadSateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadSateViewHolder {
        val binding = ProgressBarLoaderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LoadSateViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LoadSateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }



    inner class LoadSateViewHolder(private val binding: ProgressBarLoaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
            }
        }

    }
}
