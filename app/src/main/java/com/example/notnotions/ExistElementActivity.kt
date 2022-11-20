package com.example.notnotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room

class ExistElementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exist_element)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "nn_db")
            .allowMainThreadQueries()
            .build()
        val elementsDao: ElementsDao = db.getElementsDao()

        val elementLabel: String? = intent.getStringExtra("label")
        val element: Element = DBFunctions(elementsDao).getElementByLabel(elementLabel!!)

        val textLabel: TextView = findViewById(R.id.ElementLabel)
        val textUserName: TextView = findViewById(R.id.ElementLogin)
        val textPassword: TextView = findViewById(R.id.ElementPassword)
        val textSite: TextView = findViewById(R.id.ElementSite)
        val textNote: TextView = findViewById(R.id.ElementNote)

        textLabel.text = element.label
        textUserName.text = element.username
        textPassword.text = element.password
        textSite.text = element.site
        textNote.text = element.note

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}