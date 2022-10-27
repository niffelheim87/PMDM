package com.ompava.clickscounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ompava.clickscounter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var counter = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.increaseCounter.setOnClickListener(){
            counter++;
            binding.clicksCounter.setText("You have clicked $counter times")
        }

    }
}