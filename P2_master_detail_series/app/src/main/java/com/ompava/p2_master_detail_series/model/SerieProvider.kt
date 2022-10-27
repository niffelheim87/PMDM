package com.ompava.p2_master_detail_series.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ompava.p2_master_detail_series.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

//funciones para acceder y tratar los datos del modelo
class SerieProvider {
    companion object {
        fun getSeries(context: Context): MutableList<SerieModel> {
            val serieList: MutableList<SerieModel> = mutableListOf()
            val raw =
                context.resources.openRawResource(R.raw.datos_json)  //Be aware that we need the activity context
            val rd = BufferedReader(InputStreamReader(raw))

            val listType: Type = object : TypeToken<MutableList<SerieModel?>?>() {}.type

            val gson = Gson()

            serieList.addAll(gson.fromJson(rd, listType))

            return serieList
        }

        fun getSerieByID(mID: Int?, context: Context): SerieModel {
            val serie = getSeries(context).filter { serie ->
                serie.id == mID
            }
            return serie[0]
        }

        fun getFirstID(context: Context):Int{
            return getSeries(context)[0].id
        }

        fun getSerieRandom(context: Context): SerieModel {
            val position = (0..getSeries(context).lastIndex).random()
            val serie = getSeries(context).filter { serie ->
                serie.id == position
            }
            return serie[0]
        }

    }
}