package com.aiskvaa.rickandmorty.data.repositories

import com.aiskvaa.rickandmorty.base.BaseRepository
import com.aiskvaa.rickandmorty.data.local.db.daos.LocationDao
import com.aiskvaa.rickandmorty.data.remote.apiservices.LocationsApiService
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val service: LocationsApiService,
    private val locationDao: LocationDao
) :
    BaseRepository() {

    fun fetchLocation(page: Int) = doRequest(
        { service.fetchLocation(page) },
        { location -> locationDao.insertAllLocation(* location.results.toTypedArray()) })

    fun getLocations() = doRequest {
        locationDao.getAllLocation()
    }
}



