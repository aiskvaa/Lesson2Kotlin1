package com.aiskvaa.rickandmorty.data.remote.dtos.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aiskvaa.rickandmorty.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyLocation(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
   override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
) : BaseDiffModel