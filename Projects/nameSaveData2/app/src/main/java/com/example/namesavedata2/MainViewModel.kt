package com.example.namesavedata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     var displayNames: MutableLiveData<String> = MutableLiveData()
     var result: MutableLiveData<String> = MutableLiveData()
     var test1: String = ""


    fun setName() {
        displayNames.let {
        if (!it.value.equals("")) {
            test1 = it.value.toString() + "\n" + test1
            result.value = test1
        } else {
            result.value = "No Name Entered"
        }
    }
    }
//    fun setName(value: String) {
//        this.displayNames = displayNames + "\n" + value
//        result.value = displayNames.toString()
//    }

//    fun getResult(): MutableLiveData<String> {
//        return result
//    }
}
