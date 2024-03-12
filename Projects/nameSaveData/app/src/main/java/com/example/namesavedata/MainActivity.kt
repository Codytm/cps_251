package com.example.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.namesavedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.displayNames1.text = viewModel.getResult().toString()

        binding.button.setOnClickListener{
            if (binding.editTextName.text.isNotEmpty()) {
                viewModel.setName(binding.editTextName.text.toString())
                binding.displayNames1.text = viewModel.getResult()
            } else {
                binding.displayNames1.text = "No Name Entered"
            }
        }
        setContentView(binding.root)
    }



}