package com.ompava.activitylifecicle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ompava.activitylifecicle.MainActivity.Companion.KEY_EXTRA_RESULT
import com.ompava.activitylifecicle.databinding.Activity2Binding


class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //..............

        binding.btnBack.setOnClickListener{
            sendBackName()
        }
    }

    private fun sendBackName() {
        val text = binding.etName.text.toString()
        val returnIntent = Intent().apply {
            putExtra(KEY_EXTRA_RESULT, text)
        }   //Creates a new Intent with editText content as an extra

        if(text != "")
            setResult(RESULT_OK, returnIntent) //The action went ok.
        else
            setResult(RESULT_CANCELED, returnIntent)

        finish() //Finish and close this activity
    }

}