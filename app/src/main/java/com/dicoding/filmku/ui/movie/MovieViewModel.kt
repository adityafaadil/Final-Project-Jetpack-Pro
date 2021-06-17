package com.dicoding.filmku.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.vo.Resource

class MovieViewModel(private val MovieTvRepository: MovieTvRepository) : ViewModel(){

    fun getMovie(): LiveData<Resource<PagedList<Movie>>> = MovieTvRepository.getMoviePopular()

}