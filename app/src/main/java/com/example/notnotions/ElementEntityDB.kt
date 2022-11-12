package com.example.notnotions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "elements"
)
data class ElementEntityDB (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val label: String,
    val username: String,
    val password: String,
    val site: String,
    val note: String,
    val favorite: Boolean
        ){

    fun toElement(): Element = Element(
        id = id,
        label = label,
        username = username,
        password = password,
        site = site,
        note = note,
        favorite = favorite
    )

    companion object {
        fun fromNewElement(element: Element): ElementEntityDB = ElementEntityDB(
            id = 0,
            label = element.label,
            username = element.username,
            password = element.password,
            site = element.site,
            note = element.note,
            favorite = element.favorite
        )
    }
}