package com.example.notnotions.ui.generator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notnotions.DBFunctions
import com.example.notnotions.Tools
import com.example.notnotions.databinding.FragmentGeneratorBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class GeneratorFragment : Fragment() {

    private var _binding: FragmentGeneratorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val generatorViewModel =
            ViewModelProvider(this).get(GeneratorViewModel::class.java)

        _binding = FragmentGeneratorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonGenerate: Button = binding.buttonGenerate
        val passLength: EditText = binding.numberOfCharacters
        val generatedPassword: TextView = binding.generatedPassword
        val switchDigits: SwitchMaterial = binding.switchDigits
        val switchSpecialCharacters: SwitchMaterial = binding.switchSpecialCharacters
        val switchUppercase: SwitchMaterial = binding.switchUppercase


        buttonGenerate.setOnClickListener {
            val digitsOn: Boolean = switchDigits.isChecked
            val specialCharactersOn: Boolean = switchSpecialCharacters.isChecked
            val uppercaseOn: Boolean = switchUppercase.isChecked
            val length: Int = if (passLength.text?.toString()?.trim()?.equals("")!!)
                8
            else {
                passLength.text.toString().toInt()
            }
            generatedPassword.text = Tools().getRandPassword(length, digitsOn, specialCharactersOn, uppercaseOn)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}