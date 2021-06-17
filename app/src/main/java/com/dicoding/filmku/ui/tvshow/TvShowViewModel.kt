package com.dicoding.filmku.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.vo.Resource



class TvShowViewModel(private val MovieTvRepository: MovieTvRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShow>>> = MovieTvRepository.getTvPopular()
}