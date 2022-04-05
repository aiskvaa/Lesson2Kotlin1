package com.aiskvaa.rickandmorty.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtil<T : BaseDiffModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem

}