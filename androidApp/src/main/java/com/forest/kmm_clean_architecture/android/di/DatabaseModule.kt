package com.forest.kmm_clean_architecture.android.di

import app.cash.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.forest.kmm_clean_architecture.db.DatabaseDriverFactory
import forest.kmm_clean_architecture.db.ForestDatabase

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<ForestDatabase> { ForestDatabase(get()) }
}