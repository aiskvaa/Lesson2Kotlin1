package com.aiskvaa.rickandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aiskvaa.rickandmorty.data.local.db.daos.CharacterDao
import com.aiskvaa.rickandmorty.data.local.db.daos.EpisodeDao
import com.aiskvaa.rickandmorty.data.local.db.daos.LocationDao
import com.aiskvaa.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.aiskvaa.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

@Database(
    entities = [RickAndMortyCharacter::class, RickAndMortyEpisode::class, RickAndMortyLocation::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun locationDao(): LocationDao


}