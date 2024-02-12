package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun calcTip(view: View) {
        if (binding.dollarText.text.isNotEmpty()) {
            val dollarValue = binding.dollarText.text.toString().toFloat()
            val tipAmount10 = round(dollarValue * 1.10)
            val tipAmount15 = round(dollarValue * 1.15)
            val tipAmount20 = round(dollarValue * 1.20)
            binding.textView.text = buildString {
                append("The tips are as follows:\n\n")
                append("10% = " + tipAmount10.toString() + "\n")
                append("15% = " + tipAmount15.toString() + "\n")
                append("20% = " + tipAmount20.toString() + "\n")
            }
        } else {
            binding.textView.text = getString(R.string.no_value_string)
        }
    }
}