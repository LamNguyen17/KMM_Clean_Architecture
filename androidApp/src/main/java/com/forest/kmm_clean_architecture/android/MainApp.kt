package com.forest.kmm_clean_architecture.android

import com.forest.kmm_clean_architecture.android.di.databaseModule
import com.forest.kmm_clean_architecture.android.di.viewModelsModule
import com.forest.kmm_clean_architecture.di.sharedKoinModules

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@MainApp)
            modules(modules)
        }
    }
}