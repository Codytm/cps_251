package com.example.coroutineproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.random.Random
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private lateinit var viewModel: MainViewModel

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    //var names = viewModel.names

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()

        binding.recyclerView.adapter = adapter

        binding.addNameBtn.setOnClickListener {
            coroutineScope.launch(Dispatchers.Main) {
                addName()
            }
        }
    }

    suspend fun addName(){
            var nm = binding.enterName.text.toString()

            if (nm.isEmpty()) {
                Log.i("zzz", "enter a name")
            } else {
                binding.enterName.text.clear()
                binding.enterName.requestFocus()
                var num = (Random.nextInt(0, 9) * 1000)

                delay(num.toLong())
                var output = "The name is " + nm + " and the delay was " + num + " milliseconds"

                viewModel.addName(output)
                adapter?.notifyDataSetChanged()
            }
        }
    fun setupAdapter() {

    }
}