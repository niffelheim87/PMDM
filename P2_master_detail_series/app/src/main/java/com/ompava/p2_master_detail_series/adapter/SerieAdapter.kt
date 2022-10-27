package com.ompava.p2_master_detail_series.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ompava.p2_master_detail_series.R
import com.ompava.p2_master_detail_series.model.SerieModel
import com.ompava.p2_master_detail_series.view.MainActivity



//Recoge la información y la mete en el recyclerView
class SerieAdapter(private val serieList:List<SerieModel>) : RecyclerView.Adapter<SerieViewHolder>() {



    //Devuelve el item creado al viewholder por cada objeto SerieModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        //infla la vista item_serie en la vista parent y no hace attach al root
        return SerieViewHolder(layoutInflater.inflate(R.layout.item_serie, parent, false))
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {

        val item = serieList[position]
        holder.render(item, holder.itemView.context)
    }

    override fun getItemCount(): Int = serieList.size

}