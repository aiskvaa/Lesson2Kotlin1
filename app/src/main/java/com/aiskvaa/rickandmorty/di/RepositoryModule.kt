package com.aiskvaa.rickandmorty.di

import com.aiskvaa.rickandmorty.data.repositories.CharacterRepository
import com.aiskvaa.rickandmorty.data.repositories.EpisodesRepository
import com.aiskvaa.rickandmorty.data.repositories.LocationsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { CharacterRepository(get(), get()) }
    factory { EpisodesRepository(get() , get()) }
    factory { LocationsRepository(get() , get()) }
}