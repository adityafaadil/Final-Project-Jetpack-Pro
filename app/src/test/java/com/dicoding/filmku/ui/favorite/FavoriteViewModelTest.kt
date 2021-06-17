package com.dicoding.filmku.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovie: Observer<PagedList<Movie>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShow>>

    @Mock
    private lateinit var pagedListMovie: PagedList<Movie>

    @Mock
    private lateinit var pagedListTv: PagedList<TvShow>

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Before
    fun setUpMovie(){
        viewModel = FavoriteViewModel(movieTvRepository)
    }

    @Test
    fun getListFavMovie() {
        val dummyMovie = pagedListMovie
        `when`(dummyMovie.size).thenReturn(10)
        val courses = MutableLiveData<PagedList<Movie>>()
        courses.value = dummyMovie

        `when`(movieTvRepository.getFavoriteMovie()).thenReturn(courses)

        val movieEntities = viewModel.getListFavMovie().value
        //verify
        verify(movieTvRepository).getFavoriteMovie()

        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getListFavMovie().observeForever(observerMovie)
        //verify
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Before
    fun setUpTv(){
        viewModel = FavoriteViewModel(movieTvRepository)
    }

    @Test
    fun getListFavTv() {
        val dummyTvShow = pagedListTv
        `when`(dummyTvShow.size).thenReturn(10)
        val favoriteTvShow = MutableLiveData<PagedList<TvShow>>()
        favoriteTvShow.value = dummyTvShow

        `when`(movieTvRepository.getFavoriteTv()).thenReturn(favoriteTvShow)

        val tvEntities = viewModel.getListFavTv().value
        //verify
        verify(movieTvRepository).getFavoriteTv()

        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getListFavTv().observeForever(observerTvShow)
        //verify
        verify(observerTvShow).onChanged(dummyTvShow)

    }
}