package com.aiskvaa.rickandmorty.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aiskvaa.rickandmorty.base.BaseViewModel
import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import com.aiskvaa.rickandmorty.data.repositories.LocationsRepository

class LocationViewModel  constructor(
    private val repository: LocationsRepository
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false
    private val _locationsState = MutableLiveData<RickAndMortyResponse<RickAndMortyLocation>>()
    val locationsState: LiveData<RickAndMortyResponse<RickAndMortyLocation>> = _locationsState

    private val _locationsLocaleState = MutableLiveData<List<RickAndMortyLocation>>()
    val episodesLocaleState: LiveData<List<RickAndMortyLocation>> = _locationsLocaleState

    fun fetchLocation() {
        isLoading = true
        repository.fetchLocation(page).collect(_locationsState) {
            page++
            isLoading = false
        }
    }

    fun getLocation() = repository.getLocations().collect(_locationsLocaleState)


}