package com.forest.kmm_clean_architecture.di

import app.cash.sqldelight.db.SqlDriver
import com.forest.kmm_clean_architecture.db.DatabaseDriverFactory
import forest.kmm_clean_architecture.db.ForestDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<ForestDatabase> { ForestDatabase(get()) }
}