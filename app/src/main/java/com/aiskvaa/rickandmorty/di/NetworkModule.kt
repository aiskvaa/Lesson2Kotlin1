package com.aiskvaa.rickandmorty.di
import com.aiskvaa.rickandmorty.data.remote.RetrofitClient
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharactersApiService() }
    single { get<RetrofitClient>().provideEpisodesApiService() }
    single { get<RetrofitClient>().provideLocationApiService()  }


}