package com.aiskvaa.rickandmorty.data.remote.dtos.character

import com.aiskvaa.rickandmorty.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("id")
    override val id: Int,
) : BaseDiffModel