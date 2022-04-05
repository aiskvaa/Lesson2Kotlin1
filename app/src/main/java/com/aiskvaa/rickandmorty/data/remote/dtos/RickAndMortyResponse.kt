package com.aiskvaa.rickandmorty.data.remote.dtos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: ArrayList<T>

)

