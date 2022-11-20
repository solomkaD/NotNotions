package com.example.notnotions

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.notnotions.ui.main.MainFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.switchmaterial.SwitchMaterial
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
        val buttonGenerator: ImageButton = findViewById(R.id.buttonGenerator)

        buttonGenerator.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)

            val bottomSheetView = LayoutInflater.from(this).inflate(
                R.layout.layout_bottom_sheet,
                findViewById<LinearLayout>(R.id.bottomSheet)
            )

            val passLength: EditText =  bottomSheetView.findViewById(R.id.numberOfCharacters)
            val switchDigits: SwitchMaterial = bottomSheetView.findViewById(R.id.switchDigits)
            val switchSpecialCharacters: SwitchMaterial = bottomSheetView.findViewById(R.id.switchSpecialCharacters)
            val switchUppercase: SwitchMaterial = bottomSheetView.findViewById(R.id.switchUppercase)

            bottomSheetView.findViewById<View>(R.id.buttonGenerate).setOnClickListener{
                val digitsOn: Boolean = switchDigits.isChecked
                val specialCharactersOn: Boolean = switchSpecialCharacters.isChecked
                val uppercaseOn: Boolean = switchUppercase.isChecked
                val length: Int = if (passLength.text?.toString()?.trim()?.equals("")!!)
                    8
                else {
                    passLength.text.toString().toInt()
                }
                newPassword.setText(Tools().getRandPassword(length, digitsOn, specialCharactersOn, uppercaseOn))
            }

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

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

            DBFunctions(elementsDao).createElement(elementData)
            onSupportNavigateUp()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}