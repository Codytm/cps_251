package com.example.coroutineproject

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var names = arrayListOf<String>()

    fun addName(output: String) {
        names.add(output)
        Log.i("work", names.toString())
    }


}
