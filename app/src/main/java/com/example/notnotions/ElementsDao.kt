package com.example.notnotions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ElementsDao {

    @Insert
    fun createElement(elementEntityDB: ElementEntityDB)

    @Query("SELECT * FROM elements WHERE label = :label")
    fun findElementByLabel(label: String): Element

    @Query("SELECT label FROM elements")
    fun findElement(): List<String>
}