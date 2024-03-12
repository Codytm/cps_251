package com.example.lifecycleproject

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

class LifeCycleViewModel: ViewModel() {
    private var display: String = "help"

    fun displayStuff(): String {
        //display = DemoObserver().onCreate(LifecycleOwner).toString()
        return display
    }

}