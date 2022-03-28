package com.aiskvaa.rickandmorty.data.remote.apiservices

import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<RickAndMortyLocation>
}