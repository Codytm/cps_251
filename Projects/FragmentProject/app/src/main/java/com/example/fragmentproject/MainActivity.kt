package com.example.fragmentproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SecondFragment.OnFragmentInteractionListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //THEY HAVE THIS IN THE BOOK BUT I REMOVED IT AND IT DID NOT
    //MAKE A DIFFERENCE
    override fun onFragmentInteraction(uri: Uri) {
    }
}