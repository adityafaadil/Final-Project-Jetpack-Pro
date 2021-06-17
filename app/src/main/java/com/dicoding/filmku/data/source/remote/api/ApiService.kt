package com.dicoding.filmku.data.source.remote.api

import com.dicoding.filmku.data.source.remote.response.detail.DetailMovieResults
import com.dicoding.filmku.data.source.remote.response.detail.DetailTvResults
import com.dicoding.filmku.data.source.remote.response.movie.MovieResponse
import com.dicoding.filmku.data.source.remote.response.tv.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey:String
    ): Call<MovieResponse>

    @GET("tv/popular")
    fun getTv(
        @Query("api_key") apiKey: String
    ): Call<TvResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailMovieResults>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailTvResults>
}