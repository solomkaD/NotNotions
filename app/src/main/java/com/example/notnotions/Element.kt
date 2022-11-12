package com.example.notnotions

data class Element (
    val id: Long,
    val label: String,
    val username: String,
    val password: String,
    val site: String,
    val note: String,
    val favorite: Boolean,
    ) {
}

