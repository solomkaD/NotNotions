package com.example.notnotions

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.notnotions.ui.Tools
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText


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

//        val db: AppDatabase? = App.instance?.database
//        val elementsDao: ElementsDao = db!!.getElementsDao()

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "nn_db")
            .allowMainThreadQueries()
            .build()
        val elementsDao: ElementsDao = db.getElementsDao()

        buttonApply.setOnClickListener{

            val elementData = Element(
                0,
                newElementLabel.text.toString(),
                newLogin.text.toString(),
                newPassword.text.toString(),
                newSiteUrl.text.toString(),
                newNote.text.toString(),
                false)

            Tools(elementsDao).createElement(elementData)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}