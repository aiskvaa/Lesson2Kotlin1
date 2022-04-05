package com.aiskvaa.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aiskvaa.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocation(vararg location: RickAndMortyLocation)


    @Query("SELECT * FROM rickandmortylocation")
    suspend fun getAllLocation(): List<RickAndMortyLocation>
}
