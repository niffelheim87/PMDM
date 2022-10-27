package com.ompava.p2_master_detail_series.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ompava.p2_master_detail_series.R
import com.ompava.p2_master_detail_series.databinding.ItemSerieBinding
import com.ompava.p2_master_detail_series.extesions.setBitmapfromString
import com.ompava.p2_master_detail_series.model.SerieModel

class SerieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //Pinta las celdas/items del listado

    val binding = ItemSerieBinding.bind(view)

    
    fun render(Serie: SerieModel, context: Context) {
        binding.tvSerieName.text = Serie.name
        binding.tvSerieLanguage.text = Serie.language
        binding.rbSerieRating.rating = Serie.rating / 2
        binding.ivSerieImagen.setBitmapfromString(Serie?.image ?: "")


    }


}