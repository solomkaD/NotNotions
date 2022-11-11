package com.example.notnotions

data class Element (
    val label: String,
    val elementData: ElementData
    ) {
    data class ElementData (
        val username: String,
        val password: String,
        val site: String,
        val note: String,
        val favorite: Boolean,
    )
}

