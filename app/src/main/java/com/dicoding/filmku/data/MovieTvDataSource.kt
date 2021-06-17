package com.dicoding.filmku.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.vo.Resource

interface MovieTvDataSource {

    fun getMoviePopular(): LiveData<Resource<PagedList<Movie>>>

    fun getTvPopular(): LiveData<Resource<PagedList<TvShow>>>

    fun getDetailMovie(idMovie: Int): LiveData<Resource<Movie>>

    fun getDetailTvShow(idTvShow: Int): LiveData<Resource<TvShow>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

    fun setFavoriteTv(tv: TvShow, state: Boolean)

    fun getFavoriteMovie(): LiveData<PagedList<Movie>>

    fun getFavoriteTv(): LiveData<PagedList<TvShow>>
}