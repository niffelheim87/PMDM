package com.ompava.activitylifecicle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ompava.activitylifecicle.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userName: String = "Carlos"
    private val surName: String = "Tarazona"

    companion object {
        val KEY_EXTRA_NAME: String = "MY_KEY_EXTRA_NAME"
        val KEY_EXTRA_SURNAME: String = "MY_KEY_EXTRA_SURNAME"
        val KEY_EXTRA_RESULT: String = "MY_KEY_EXTRA_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoActivity2.setOnClickListener { openSomeActivityForResult() }
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                binding.tvGreeting.text =
                    "Hello ${data?.getStringExtra(KEY_EXTRA_RESULT) ?: "No return"}"
            }
        }


    fun openSomeActivityForResult() {
        val intent = Intent(this, Activity2::class.java)
        resultLauncher.launch(intent)
    }
}
