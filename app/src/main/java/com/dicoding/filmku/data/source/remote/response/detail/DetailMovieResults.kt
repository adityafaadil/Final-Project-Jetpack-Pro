package com.dicoding.filmku.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName

data class DetailMovieResults (
    @field:SerializedName("id")
    val movieId: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val imagePath: String,
)
