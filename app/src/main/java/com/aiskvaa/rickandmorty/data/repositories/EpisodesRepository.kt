package com.aiskvaa.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.aiskvaa.rickandmorty.data.remote.apiservices.EpisodesApiService
import com.aiskvaa.rickandmorty.data.remote.pagingsources.EpisodesPAgingSource
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApiService: EpisodesApiService
) {
    fun fetchEpisodes() = Pager(
        PagingConfig(pageSize = 20)
    ) {
        EpisodesPAgingSource(episodesApiService)
    }.flow


}