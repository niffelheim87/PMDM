package com.ompava.saludapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ompava.saludapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowName?.setOnClickListener{
            checkValue()
        }

    }

    private fun checkValue(){
        if(binding.etName?.text?.isNotEmpty() == true){
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("INTENT_NAME", binding.etName!!.text)
            startActivity(intent)
            //vamos a la nueva pantalla
        } else{
            showErrorName()
            //mostramos un diálogo

        }
    }

    private fun showErrorName(){
        Toast.makeText(this, "El nombre del usuario no puede ser vacio", Toast.LENGTH_SHORT).show()
    }
}