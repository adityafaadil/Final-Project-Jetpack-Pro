package com.dicoding.filmku.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class ResultTvShow(

    @field:SerializedName("id")
    val showId: Int,

    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val imagePath: String,
)
