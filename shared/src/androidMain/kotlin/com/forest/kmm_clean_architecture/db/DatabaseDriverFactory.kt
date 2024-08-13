package com.forest.kmm_clean_architecture.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import forest.kmm_clean_architecture.db.ForestDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ForestDatabase.Schema,
            context = context,
            name = "ForestDatabase.Database.db"
        )
}