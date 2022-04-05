package com.aiskvaa.rickandmorty.presentation.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aiskvaa.rickandmorty.base.BaseViewModel
import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.aiskvaa.rickandmorty.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false

    private val _characterState = MutableLiveData<RickAndMortyResponse<RickAndMortyCharacter>>()
    val characterState: LiveData<RickAndMortyResponse<RickAndMortyCharacter>> = _characterState

    private val _characterLocaleState = MutableLiveData<List<RickAndMortyCharacter>>()
    val characterLocaleState: LiveData<List<RickAndMortyCharacter>> = _characterLocaleState

    fun fetchCharacter() {
        isLoading = true
        repository.fetchCharacters(page).collect(_characterState) {
            page++
            isLoading = false
        }
    }

    fun getCharacters() = repository.getCharacters().collect(_characterLocaleState)

}
