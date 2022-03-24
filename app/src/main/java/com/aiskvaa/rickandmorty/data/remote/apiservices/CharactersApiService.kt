package com.aiskvaa.rickandmorty.data.remote.apiservices
import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersApiService {

    @GET("api/character")
    suspend fun fetchCharacters(): RickAndMortyResponse<RickAndMortyCharacter>

    @GET("api/character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): RickAndMortyCharacter
}