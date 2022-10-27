package com.ompava.p1converter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ompava.p1converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //To convert a String to binary and return a String for EditText
    private fun toBinary(s: String): String {
        val n: Int = s.toInt()
        return Integer.toBinaryString(n)
    }

    //To convert a String to decimal and return a String for EditText
    private fun toDecimal(s: String): String {
        val n: Int = s.toInt(2)
        return n.toString()
    }

    //Check if String chars is a number between 0 and 9
    private fun isNumber(s: String) = s.all { it in '0'..'9' }

    //Check if String chars is a number between 0 and 1
    private fun isBinary(s: String) = s.all { it in '0'..'1' }

    //Convert a String to Editable for EditText.text = String instead of using EditText.setText()
    //fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {

            swcambiador.setOnClickListener {

                if (binding.swcambiador.isChecked) {
                    binding.ptResultado.setText(getString(R.string.binary))
                    binding.ptIntroducir.setText(getString(R.string.decimal))
                } else {
                    binding.ptResultado.setText(getString(R.string.decimal))
                    binding.ptIntroducir.setText(getString(R.string.binary))
                }


            }

            btncalcular.setOnClickListener {
                val valor: String = binding.ptIntroducir.text.toString()
                if (!isNumber(valor)) {
                    binding.ptResultado.setText(getString(R.string.errornotnum))
                } else if (valor.length > 10) {
                    binding.ptResultado.setText(getString(R.string.errorbig))
                } else if (binding.swcambiador.isChecked) {
                    if (valor.toInt() < 1024) {
                        binding.ptResultado.setText(toBinary(valor))
                    } else {
                        binding.ptResultado.setText(getString(R.string.errorbig))
                    }

                } else if (isBinary(valor)) {
                    binding.ptResultado.setText(toDecimal(valor))
                } else {
                    binding.ptResultado.setText(getString(R.string.errorbinary))
                }
            }


        }


    }


}








