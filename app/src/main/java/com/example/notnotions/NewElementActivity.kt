package com.example.notnotions

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.io.FileOutputStream
import com.example.notnotions.ElementData
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class NewElementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_element)

        val toolbar: Toolbar = findViewById(R.id.materialToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val buttonApply: FloatingActionButton = findViewById(R.id.applyButton)
        val newElementLabel: EditText = findViewById(R.id.newElementLabel)
        val newLogin: EditText = findViewById(R.id.newElementLogin)
        val newPassword: EditText = findViewById(R.id.newElementPassword)
        val newSiteUrl: EditText = findViewById(R.id.newElementSite)
        val newNote: TextInputEditText = findViewById(R.id.newElementNote)

        val elementData = ElementData(
            newElementLabel.text.toString(),
            newLogin.text.toString(),
            newPassword.text.toString(),
            newSiteUrl.text.toString(),
            newNote.text.toString(),
            true)

        val filename = "myfile"
        val string = "Hello world!"
        val outputStream: FileOutputStream

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE)
            outputStream.write(string.toByteArray())
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}