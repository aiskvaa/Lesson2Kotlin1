package com.aiskvaa.rickandmorty.data.repositories

import androidx.lifecycle.liveData
import com.aiskvaa.rickandmorty.common.resource.Resource
import com.aiskvaa.rickandmorty.data.remote.apiservices.LocationsApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsApiService: LocationsApiService
) {
    fun fetchLocations() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(locationsApiService.fetchEpisode()))
        } catch (ioException: Exception) {
            emit(Resource.Error(  null  , ioException.localizedMessage ))
        }

    }
}