package com.example.notnotions

import com.example.notnotions.Element
import com.example.notnotions.ElementEntityDB
import com.example.notnotions.ElementsDao


class Tools (
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