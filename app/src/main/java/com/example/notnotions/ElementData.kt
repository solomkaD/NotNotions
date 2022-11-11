package com.example.notnotions
import android.content.Context
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.FileOutputStream
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData

data class ElementData (
    private val label: String,
    val username: String,
    val password: String,
    val site: String,
    val note: String,
    val favorite: Boolean
    )