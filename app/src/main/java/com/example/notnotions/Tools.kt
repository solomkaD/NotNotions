package com.example.notnotions

import kotlin.random.Random

class Tools {

    fun getRandPassword(
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