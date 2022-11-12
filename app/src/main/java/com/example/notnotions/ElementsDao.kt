package com.example.notnotions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementsDao {

    @Insert
    fun createElement(elementEntityDB: ElementEntityDB)

    @Query("SELECT * FROM elements WHERE label = :label")
    fun findElement(label: String): Flow<ElementEntityDB?>
}