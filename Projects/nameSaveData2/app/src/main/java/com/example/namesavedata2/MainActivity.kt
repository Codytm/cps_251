package com.example.namesavedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.namesavedata2.databinding.ActivityMainBinding
import com.example.namesavedata2.BR.myViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.lifecycleOwner = this
        binding.setVariable(myViewModel, viewModel)

        //binding.displayNames.text = viewModel.getResult().toString()
//        val resultObserver = Observer<String> {
//                result -> binding.displayNames.text = result
//        }
//
//        viewModel.getResult().observe(this, resultObserver)
//
//        binding.button.setOnClickListener{
//            if (binding.editTextName.text.isNotEmpty()) {
//                viewModel.setName(binding.editTextName.text.toString())
//               // binding.displayNames.text = viewModel.getResult()
//            } else {
//                binding.displayNames.text = "No Name Entered"
//            }
//        }
        setContentView(binding.root)
    }
}
