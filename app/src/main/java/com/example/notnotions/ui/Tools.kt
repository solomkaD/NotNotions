package com.example.notnotions.ui

import android.content.Context
import com.example.notnotions.ElementData
import com.google.gson.Gson
import java.io.FileOutputStream

class Tools {

    private val fileName = "data.json"

    fun addNewElement(context: Context, elementData: ElementData): Boolean {

        val gson = Gson()
        val elementDataJson = gson.toJson(elementData)
        val outputStream: FileOutputStream

        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
            outputStream.write(elementDataJson.toByteArray())
            outputStream.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }


}