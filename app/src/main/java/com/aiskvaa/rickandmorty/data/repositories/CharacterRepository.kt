package com.aiskvaa.rickandmorty.data.repositories

import com.aiskvaa.rickandmorty.base.BaseRepository
import com.aiskvaa.rickandmorty.data.local.db.daos.CharacterDao
import com.aiskvaa.rickandmorty.data.remote.apiservices.CharactersApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharactersApiService,
    private val characterDao: CharacterDao
) :
    BaseRepository() {
    fun fetchCharacters(page: Int) = doRequest(
        { service.fetchCharacters(page) },
        { characters ->
            characterDao.insertAll(*characters.results.toTypedArray())
        }
    )

    fun getCharacters() = doRequest {
        characterDao.getAll()
    }
}