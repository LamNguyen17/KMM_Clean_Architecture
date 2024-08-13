package com.forest.kmm_clean_architecture.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import forest.kmm_clean_architecture.db.ForestDatabase

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = ForestDatabase.Schema,
            name = "ForestDatabase.db"
        )
}