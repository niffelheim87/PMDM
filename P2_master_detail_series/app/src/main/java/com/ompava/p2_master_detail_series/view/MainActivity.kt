package com.ompava.p2_master_detail_series.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.recyclerSerie.layoutManager = LinearLayoutManager(this)
        binding.recyclerSerie.adapter = SerieAdapter(SerieProvider.getSeries(this))
    }


}