package com.dicoding.filmku.di

import android.content.Context
import com.dicoding.filmku.data.MovieTvRepository
import com.dicoding.filmku.data.source.local.LocalDataSource
import com.dicoding.filmku.data.source.local.room.MovieTvDatabase
import com.dicoding.filmku.data.source.remote.RemoteDataSource
import com.dicoding.filmku.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context): MovieTvRepository {

        val database = MovieTvDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getINSTANCE(database.catalogueDao())
        val appExecutors = AppExecutors()

        return MovieTvRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}