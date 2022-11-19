package com.example.notnotions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
        val element: Element = Tools(elementsDao).getElementByLabel(elementLabel!!)

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