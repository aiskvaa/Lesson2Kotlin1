package com.aiskvaa.rickandmorty.presentation.ui.fragments.episode
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aiskvaa.rickandmorty.base.BaseViewModel
import com.aiskvaa.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.aiskvaa.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.aiskvaa.rickandmorty.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodesRepository
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false

    private val _episodesState = MutableLiveData<RickAndMortyResponse<RickAndMortyEpisode>>()
    val episodesState: LiveData<RickAndMortyResponse<RickAndMortyEpisode>> = _episodesState

    private val _episodesLocaleState = MutableLiveData<List<RickAndMortyEpisode>>()
    val episodesLocaleState: LiveData<List<RickAndMortyEpisode>> = _episodesLocaleState

    fun fetchEpisodes() {
        isLoading = true
        episodeRepository.fetchEpisode(page).collect(_episodesState) {
            page++
            isLoading = false
        }
    }

    fun getEpisodes() = episodeRepository.getEpisodes().collect(_episodesLocaleState)
}