package com.aiskvaa.rickandmorty.di
import com.aiskvaa.rickandmorty.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharactersApiService() = retrofitClient.provideCharactersApiService()

    @Singleton
    @Provides
    fun provideLocationsApiService() = retrofitClient.provideLocationApiService()

    @Singleton
    @Provides
    fun provideEpisodesApiService() = retrofitClient.provideEpisodesApiService()


}