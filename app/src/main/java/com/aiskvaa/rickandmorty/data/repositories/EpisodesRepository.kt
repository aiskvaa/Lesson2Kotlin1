package com.aiskvaa.rickandmorty.data.repositories

import com.aiskvaa.rickandmorty.base.BaseRepository
import com.aiskvaa.rickandmorty.data.local.db.daos.EpisodeDao
import com.aiskvaa.rickandmorty.data.remote.apiservices.EpisodesApiService
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val service: EpisodesApiService,
    private val episodeDao: EpisodeDao
) :
    BaseRepository() {

    fun fetchEpisode(page: Int) = doRequest(
        { service.fetchEpisodes(page) },
        { episodes -> episodeDao.insertAllEpisode(* episodes.results.toTypedArray()) })


    fun getEpisodes() = doRequest {
        episodeDao.getAllEpisode()
    }
}