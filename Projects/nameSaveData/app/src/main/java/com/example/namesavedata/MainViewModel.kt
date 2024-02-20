package com.example.namesavedata

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var displayNames = ""
    private var result: String = "No names to display"
    fun setName(value: String) {
        this.displayNames = displayNames + "\n" + value
        result = displayNames
    }

    fun getResult(): String {
        return result
    }
}
