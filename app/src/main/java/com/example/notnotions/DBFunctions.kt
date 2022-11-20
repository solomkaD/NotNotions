package com.example.notnotions

import kotlin.random.Random


class DBFunctions (
    private val elementsDao: ElementsDao
        ) {

    fun createElement(element: Element) {
        val entity = ElementEntityDB.fromNewElement(element)
        elementsDao.createElement(entity)
    }

    fun getElementByLabel(label: String): Element {
        return elementsDao.findElementByLabel(label)
    }

    fun getElement(): List<String> {
        return elementsDao.findElement()
    }

}