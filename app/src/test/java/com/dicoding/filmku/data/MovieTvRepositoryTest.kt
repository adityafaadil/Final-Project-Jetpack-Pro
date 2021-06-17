package com.dicoding.filmku.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.filmku.data.source.local.LocalDataSource
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.data.source.remote.RemoteDataSource
import com.dicoding.filmku.utils.*
import com.dicoding.filmku.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class MovieTvRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val movieTvRepository = FakeMovieTvRepository(remote, local, appExecutors)

    private val movieResponse = MovieDummy.getMoviesResponse()
    private val movId = movieResponse[0].movieId
    private val tvResponse = TvShowDummy.getTvShowResponse()
    private val tvsId = tvResponse[0].showId

    @Test
    fun getMoviePopular() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(local.getDataMovie()).thenReturn(dataSourceFactory)
        movieTvRepository.getMoviePopular()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(MovieDummy.getMovie()))
        //verify
        verify(local).getDataMovie()

        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = MovieDummy.getMovieDetail()

        `when`(movId.let { local.getMovieId(it) }).thenReturn(dummyEntity)

        val movieDetailEntity = LiveDataTestUtil.getValue(movieTvRepository.getDetailMovie(movId))
        //verify
        verify(local).getMovieId(movId)

        assertNotNull(movieDetailEntity.data)
        assertNotNull(movieDetailEntity.data?.title)
    }

    @Test
    fun getTvPopular() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getDataTv()).thenReturn(dataSourceFactory)
        movieTvRepository.getTvPopular()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(TvShowDummy.getTvShow()))
        //verify
        verify(local).getDataTv()

        assertNotNull(tvEntities)
        assertEquals(tvResponse.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getTvDetail() {
        val dummyEntity = MutableLiveData<TvShow>()
        dummyEntity.value = TvShowDummy.getTvShowDetail()

        `when`(tvsId.let { local.getTvId(it) }).thenReturn(dummyEntity)

        val tvDetailEntities = LiveDataTestUtil.getValue(movieTvRepository.getDetailTvShow(tvsId))
        //verify
        verify(local).getTvId(tvsId)

        assertNotNull(tvDetailEntities)
        assertNotNull(tvDetailEntities.data?.title)
    }

    @Test
    fun getFavoriteMovie(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(local.getFavMovie()).thenReturn(dataSourceFactory)
        movieTvRepository.getFavoriteMovie()

        val favMovEntities = Resource.success(PagedListUtil.mockPagedList(MovieDummy.getMovie()))
        //verify
        verify(local).getFavMovie()

        assertNotNull(favMovEntities)
        assertEquals(movieResponse.size.toLong(), favMovEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getFavTv()).thenReturn(dataSourceFactory)
        movieTvRepository.getFavoriteTv()

        val favTvEntities = Resource.success((PagedListUtil.mockPagedList(TvShowDummy.getTvShow())))
        //verify
        verify(local).getFavTv()

        assertNotNull(favTvEntities)
        assertEquals(tvResponse.size.toLong(), favTvEntities.data?.size?.toLong())
    }
}