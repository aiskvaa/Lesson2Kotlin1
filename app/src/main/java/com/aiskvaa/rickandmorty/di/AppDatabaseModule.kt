package com.aiskvaa.rickandmorty.di

import com.aiskvaa.rickandmorty.data.local.db.RoomClient
import org.koin.dsl.module

val appDatabaseModule = module {

    single { RoomClient() }
    single { get<RoomClient>().provideCreateAppDatabase(get()) }
    single { get<RoomClient>().provideCharacterDao(get()) }
    single { get<RoomClient>().provideLocationDao(get()) }
    single { get<RoomClient>().provideEpisodeDao(get()) }
}