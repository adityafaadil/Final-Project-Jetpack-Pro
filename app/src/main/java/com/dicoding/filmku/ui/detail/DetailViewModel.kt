package com.dicoding.filmku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.vo.Resource


class DetailViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    private var catalogueId = MutableLiveData<Int>()

    fun setDetailMovie(catalogueId: Int) {
        this.catalogueId.value = catalogueId
    }

    fun setDetailTv(catalogueId: Int) {
        this.catalogueId.value = catalogueId
    }

    var getDetailMovie: LiveData<Resource<Movie>> = Transformations.switchMap(catalogueId) {
        movieTvRepository.getDetailMovie(it) }

    var getDetailTvShow: LiveData<Resource<TvShow>> = Transformations.switchMap(catalogueId) {
        movieTvRepository.getDetailTvShow(it) }


    fun setFavoriteMovie() {
        val dataMovie = getDetailMovie.value
        if (dataMovie != null) {
            val entity = dataMovie.data

            if (entity != null) {
                val newState = !entity.favorite
                movieTvRepository.setFavoriteMovie(entity, newState)
                }
            }
        }

    fun setFavoriteTv() {
        val dataTv = getDetailTvShow.value
        if (dataTv != null) {
            val entity = dataTv.data

            if (entity != null) {
                val newState = !entity.favorite
                movieTvRepository.setFavoriteTv(entity, newState)
            }
        }
    }
}
