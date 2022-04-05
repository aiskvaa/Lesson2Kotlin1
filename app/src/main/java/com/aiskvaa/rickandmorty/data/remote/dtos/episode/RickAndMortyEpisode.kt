package com.aiskvaa.rickandmorty.data.remote.dtos.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aiskvaa.rickandmorty.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyEpisode(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episodes")
    val episode: String
) :BaseDiffModel