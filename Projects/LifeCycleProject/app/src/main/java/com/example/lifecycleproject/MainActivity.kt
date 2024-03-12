package com.example.lifecycleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var demoOwner: DemoOwner
    private lateinit var viewModel: LifeCycleViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[LifeCycleViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        lifecycle.addObserver(DemoObserver())

        //demoOwner = DemoOwner(this.lifecycle)
        //demoOwner.startOwner()
        //demoOwner.stopOwner()
        //viewModel.displayStuff(DemoObserver().onCreate(LifecycleOwner))

        //binding.display1.text

        binding.display1.text = viewModel.displayStuff()




        setContentView(binding.root)
    }

}



