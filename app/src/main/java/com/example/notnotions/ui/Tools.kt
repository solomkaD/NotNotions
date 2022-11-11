package com.example.notnotions.ui

import android.content.Context
import com.example.notnotions.Element
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.util.stream.Collectors
import java.util.stream.IntStream


class Tools {

    private val fileName = "data.json"

    fun addNewElement(context: Context, element: Element): Boolean {

        val gson = Gson()
        val elementDataJson = gson.toJson(element)
        val outputStream: FileOutputStream

        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_APPEND)
            outputStream.write(elementDataJson.toByteArray())
            outputStream.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun readElement(context: Context): JsonArray{
        try {
            val inputStream: FileInputStream = context.openFileInput(fileName)
            val streamReader: InputStreamReader = InputStreamReader(inputStream)
            val gson = Gson()
            return gson.fromJson(streamReader, JsonArray::class.java)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return JsonArray()
    }

    fun getValuesForGivenKey(jsonArrayStr: String?, key: String?): List<String?>? {
        val jsonArray = JSONArray(jsonArrayStr)
        return IntStream.range(0, jsonArray.length())
            .mapToObj { index -> (jsonArray[index] as JSONObject).optString(key) }
            .collect(Collectors.toList())
    }
}