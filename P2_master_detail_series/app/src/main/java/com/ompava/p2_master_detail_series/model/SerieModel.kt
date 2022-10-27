package com.ompava.p2_master_detail_series.model

data class SerieModel(
    //modelo que tiene los atributos de la clase Serie importados del JSON
    val id: Int,
    val name: String,
    val language: String,
    val genres: Array<String>,
    val status: String,
    val premiered: String,
    val officialsite: String,
    val rating: Float,
    val image: String,
    val summary: String

) {


}