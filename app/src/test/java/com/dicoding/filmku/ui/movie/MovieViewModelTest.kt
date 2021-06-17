package com.dicoding.filmku.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieTvRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(pagedList)
        Mockito.`when`(dummyMovie.data?.size).thenReturn(10)
        val listMovie = MutableLiveData<Resource<PagedList<Movie>>>()
        listMovie.value = dummyMovie

        Mockito.`when`(movieRepository.getMoviePopular()).thenReturn(listMovie)

        val movieEntity = viewModel.getMovie().value?.data
        //verify
        verify(movieRepository).getMoviePopular()

        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getMovie().observeForever(observer)
        //verify
        verify(observer).onChanged(dummyMovie)
    }
}