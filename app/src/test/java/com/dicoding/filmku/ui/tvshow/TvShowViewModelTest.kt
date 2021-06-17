package com.dicoding.filmku.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.entity.TvShow
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: MovieTvRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShow>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShow>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(tvRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = Resource.success(pagedList)
        Mockito.`when`(dummyTvShow.data?.size).thenReturn(10)
        val courses = MutableLiveData<Resource<PagedList<TvShow>>>()
        courses.value = dummyTvShow

        Mockito.`when`(tvRepository.getTvPopular()).thenReturn(courses)
        val tvShowEntity = viewModel.getTvShow().value?.data
        verify(tvRepository).getTvPopular()
        assertEquals(10, tvShowEntity?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}