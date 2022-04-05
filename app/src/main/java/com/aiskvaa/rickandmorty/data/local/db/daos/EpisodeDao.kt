package com.aiskvaa.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aiskvaa.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisode(vararg episode: RickAndMortyEpisode)

    @Query("SELECT * FROM rickandmortyepisode")
    suspend fun getAllEpisode(): List<RickAndMortyEpisode>

}