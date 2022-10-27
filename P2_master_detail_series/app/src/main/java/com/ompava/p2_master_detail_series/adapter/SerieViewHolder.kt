package com.ompava.p2_master_detail_series.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ompava.p2_master_detail_series.R
import com.ompava.p2_master_detail_series.extesions.setBitmapfromString
import com.ompava.p2_master_detail_series.model.SerieModel

class SerieViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //Pinta las celdas/items del listado

    val serieImagen = view.findViewById<ImageView>(R.id.ivSerieImagen)
    val serieName = view.findViewById<TextView>(R.id.tvSerieName)
    val serieLanguage = view.findViewById<TextView>(R.id.tvSerieLanguage)
    val serieRating = view.findViewById<RatingBar>(R.id.rbSerieRating)

    fun render(Serie: SerieModel, context : Context){
        serieName.text = Serie.name
        serieLanguage.text = Serie.language
        serieRating.rating = Serie.rating/2
        serieImagen.setBitmapfromString(Serie?.image?:"")



    }


}