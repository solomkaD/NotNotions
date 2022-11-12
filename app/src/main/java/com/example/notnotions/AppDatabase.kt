package com.example.notnotions

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        ElementEntityDB::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getElementsDao(): ElementsDao

}