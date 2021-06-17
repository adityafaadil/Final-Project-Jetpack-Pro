package com.dicoding.filmku.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow

class FavoriteViewModel(private val movieTvRepository: MovieTvRepository): ViewModel() {

    fun getListFavMovie(): LiveData<PagedList<Movie>> = movieTvRepository.getFavoriteMovie()

    fun setListFavMovie(movieEntity: Movie) {
        val newState = !movieEntity.favorite
        movieTvRepository.setFavoriteMovie(movieEntity, newState)
    }

    fun getListFavTv(): LiveData<PagedList<TvShow>> = movieTvRepository.getFavoriteTv()

    fun setListFavTv(tvShowEntity: TvShow) {
        val newState = !tvShowEntity.favorite
        movieTvRepository.setFavoriteTv(tvShowEntity, newState)
    }
}