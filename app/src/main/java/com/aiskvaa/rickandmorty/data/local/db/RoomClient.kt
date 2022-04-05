package com.aiskvaa.rickandmorty.data.local.db

import android.content.Context
import androidx.room.Room
import com.aiskvaa.rickandmorty.data.local.db.daos.CharacterDao
import com.aiskvaa.rickandmorty.data.local.db.daos.EpisodeDao
import com.aiskvaa.rickandmorty.data.local.db.daos.LocationDao

class RoomClient {

    fun provideCreateAppDatabase(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database"
    ).fallbackToDestructiveMigration().allowMainThreadQueries()
        .build()

    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao = appDatabase.characterDao()

    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodeDao = appDatabase.episodeDao()

    fun provideLocationDao(appDatabase: AppDatabase): LocationDao = appDatabase.locationDao()
}