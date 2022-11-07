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
import com.example.notnotions.databinding.FragmentGeneratorBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random

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


        buttonGenerate?.setOnClickListener {
            val length: Int
            val digitsOn: Boolean = switchDigits.isChecked()
            val specialCharactersOn: Boolean = switchSpecialCharacters.isChecked()
            val uppercaseOn: Boolean = switchUppercase.isChecked()
            if (passLength?.text?.toString()?.trim()?.equals("")!!)
                length = 8
            else {
                length = passLength.text.toString().toInt()
            }
            generatedPassword.text = getRandPassword(length, digitsOn, specialCharactersOn, uppercaseOn)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getRandPassword(
        length: Int,
        digitsOn: Boolean,
        specialCharactersOn:
        Boolean, uppercaseOn:
        Boolean
    ): String {
        var characterSet = "abcdefghijklmnopqrstuvwxyz"
        val digits = "0123456789"
        val uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val special = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~"
        if (digitsOn and specialCharactersOn and uppercaseOn)
            characterSet += digits + uppercase + special
        else if (digitsOn and uppercaseOn)
            characterSet += digits + uppercase
        else if (digitsOn and specialCharactersOn)
            characterSet += digits + special
        else if (digitsOn)
            characterSet += digits
        else if (uppercaseOn and specialCharactersOn)
            characterSet += uppercase + special
        else if (uppercaseOn)
            characterSet += uppercase
        else if (specialCharactersOn)
            characterSet += special


        val random = Random(System.nanoTime())
        val password = StringBuilder()

        for (i in 0 until length) {
            val rIndex = random.nextInt(characterSet.length)
            password.append(characterSet[rIndex])
        }

        return password.toString()

    }
}