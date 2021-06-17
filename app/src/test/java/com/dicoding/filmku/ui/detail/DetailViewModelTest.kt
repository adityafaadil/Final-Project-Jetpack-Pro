package com.dicoding.filmku.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.utils.MovieDummy
import com.dicoding.filmku.utils.TvShowDummy
import com.dicoding.filmku.vo.Resource
import junit.framework.TestCase
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    private val dummyMovies = MovieDummy.getMovie()[0]
    private val movId = dummyMovies.movieId
    private val dummyTvShows = TvShowDummy.getTvShow()[0]
    private val tvShowId = dummyTvShows.showId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private var movieTvRepository = Mockito.mock(MovieTvRepository::class.java)

    @Mock
    private lateinit var movieObserver: Observer<Resource<Movie>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvShow>>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(movieTvRepository)
    }

    @Test
    fun getDetailMovie() {
        movId?.let { detailViewModel.setDetailMovie(it) }

        val moviesDetail = Resource.success(MovieDummy.getMovieDetail())
        val course = MutableLiveData<Resource<Movie>>()
        course.value = moviesDetail

        `when`(movId?.let { movieTvRepository.getDetailMovie(it) }).thenReturn(course)

        detailViewModel.getDetailMovie.observeForever(movieObserver)
        verify(movieTvRepository).getDetailMovie(movId!!)

        assertNotNull(detailViewModel.getDetailMovie)
        assertEquals(detailViewModel.getDetailMovie.value?.data?.movieId, dummyMovies.movieId)
    }

    @Test
    fun setFavoriteMovie() {
        movId?.let { detailViewModel.setDetailMovie(it) }

        val favMovDetail = Resource.success(MovieDummy.getMovie()[0])
        val favMovie = MutableLiveData<Resource<Movie>>()
        favMovie.value = favMovDetail

        `when`(movId?.let { movieTvRepository.getDetailMovie(it) }).thenReturn(favMovie)
        detailViewModel.setFavoriteMovie()

        detailViewModel.getDetailMovie.observeForever(movieObserver)
        verify(movieObserver).onChanged(favMovie.value)

        val expectedValue = favMovie.value
        val actualValue = detailViewModel.getDetailMovie.value

        TestCase.assertEquals(expectedValue, actualValue)
    }

    @Before
    fun setUpT() {
        detailViewModel = DetailViewModel(movieTvRepository)
    }

    @Test
    fun getDetailTv() {
        tvShowId?.let { detailViewModel.setDetailTv(it) }

        val tvsDetail = Resource.success(TvShowDummy.getTvShow()[0])
        val course = MutableLiveData<Resource<TvShow>>()
        course.value = tvsDetail

        `when`(tvShowId?.let { movieTvRepository.getDetailTvShow(it) }).thenReturn(course)

        detailViewModel.getDetailTvShow.observeForever(tvObserver)
        verify(movieTvRepository).getDetailTvShow(tvShowId!!)

        assertNotNull(detailViewModel.getDetailTvShow)
        assertEquals(detailViewModel.getDetailTvShow.value?.data?.showId, dummyTvShows.showId)
    }

    @Test
    fun setFavoriteTv() {
        tvShowId?.let { detailViewModel.setDetailTv(it) }

        val favTvDetail = Resource.success(TvShowDummy.getTvShow()[0])
        val favTvShow = MutableLiveData<Resource<TvShow>>()
        favTvShow.value = favTvDetail

        `when`(tvShowId?.let { movieTvRepository.getDetailTvShow(it) }).thenReturn(favTvShow)
        detailViewModel.setFavoriteTv()

        detailViewModel.getDetailTvShow.observeForever(tvObserver)
        verify(tvObserver).onChanged(favTvShow.value)

        val expectedValue = favTvShow.value
        val actualValue = detailViewModel.getDetailTvShow.value

        TestCase.assertEquals(expectedValue, actualValue)
    }
}