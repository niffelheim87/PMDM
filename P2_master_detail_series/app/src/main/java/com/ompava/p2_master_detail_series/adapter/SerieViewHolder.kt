package com.ompava.p2_master_detail_series.adapter

import android.content.Context
import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ompava.p2_master_detail_series.databinding.ItemSerieBinding
import com.ompava.p2_master_detail_series.model.SerieModel

class SerieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //Pinta las celdas/items del listado

    val binding = ItemSerieBinding.bind(view)


    fun render(Serie: SerieModel, context: Context) {
        binding.tvSerieName.text = Serie.name
        binding.tvSerieLanguage.text = Serie.language
        binding.rbSerieRating.rating = Serie.rating / 2
        val imgName = Serie.image.split(".")[0]
        Glide.with(context)
            .load(context.resources.getIdentifier(imgName, "drawable", context.packageName))
            .into(binding.ivSerieImagen)


    }


}