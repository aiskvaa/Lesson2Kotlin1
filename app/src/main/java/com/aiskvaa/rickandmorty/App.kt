package com.aiskvaa.rickandmorty

import android.app.Application
import com.aiskvaa.rickandmorty.di.appDatabaseModule
import com.aiskvaa.rickandmorty.di.networkModule
import com.aiskvaa.rickandmorty.di.repositoryModule
import com.aiskvaa.rickandmorty.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(networkModule , repositoryModule , viewModelModule, appDatabaseModule)
        }
    }
}

