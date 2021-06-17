package com.dicoding.filmku.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName

data class DetailTvResults (
    @field:SerializedName("id")
    val showId: Int,

    @field:SerializedName("original_name")
    val title: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val imagePath: String,
)
