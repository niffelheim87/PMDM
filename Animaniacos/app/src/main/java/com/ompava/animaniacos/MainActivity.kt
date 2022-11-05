package com.ompava.animaniacos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ompava.animaniacos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?)!!.navController

        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController);
    }
}