package com.aiskvaa.rickandmorty.di

import android.content.Context
import com.aiskvaa.rickandmorty.data.local.db.AppDatabase
import com.aiskvaa.rickandmorty.data.local.db.RoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Singleton
    private val roomClient = RoomClient()


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        roomClient.provideCreateAppDatabase(context)


    @Singleton
    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase) =
        roomClient.provideCharacterDao(appDatabase)


    @Singleton
    @Provides
    fun provideEpisodeDao(appDatabase: AppDatabase) =
        roomClient.provideEpisodeDao(appDatabase)

    @Singleton
    @Provides
    fun provideLocationDao(appDatabase: AppDatabase) =
        roomClient.provideLocationDao(appDatabase)
}