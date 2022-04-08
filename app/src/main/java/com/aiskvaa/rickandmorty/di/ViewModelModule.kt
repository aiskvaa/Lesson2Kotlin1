package com.aiskvaa.rickandmorty.di

import com.aiskvaa.rickandmorty.presentation.ui.fragments.character.CharacterViewModel
import com.aiskvaa.rickandmorty.presentation.ui.fragments.episode.EpisodeViewModel
import com.aiskvaa.rickandmorty.presentation.ui.fragments.location.LocationViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }

}