package com.dicoding.filmku.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class ResultMovie(

    @SerializedName("id")
    var movieId: Int,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("overview")
    var overview: String
)