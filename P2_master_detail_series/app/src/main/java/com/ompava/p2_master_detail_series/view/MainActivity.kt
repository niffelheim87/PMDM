package com.ompava.p2_master_detail_series.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ompava.p2_master_detail_series.R
import com.ompava.p2_master_detail_series.adapter.SerieAdapter
import com.ompava.p2_master_detail_series.databinding.ActivityMainBinding
import com.ompava.p2_master_detail_series.model.SerieProvider


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSerie)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SerieAdapter(SerieProvider.getSeries(this))
    }


}