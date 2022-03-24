package com.aiskvaa.rickandmorty.data.remote.apiservices

import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchEpisode(): RickAndMortyResponse<RickAndMortyLocation>
}