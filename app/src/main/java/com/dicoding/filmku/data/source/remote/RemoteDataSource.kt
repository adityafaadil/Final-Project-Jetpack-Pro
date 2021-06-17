package com.dicoding.filmku.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.filmku.Constant.Companion.API_KEY
import com.dicoding.filmku.data.source.remote.api.ApiConfig
import com.dicoding.filmku.data.source.remote.response.detail.DetailMovieResults
import com.dicoding.filmku.data.source.remote.response.detail.DetailTvResults
import com.dicoding.filmku.data.source.remote.response.movie.MovieResponse
import com.dicoding.filmku.data.source.remote.response.movie.ResultMovie
import com.dicoding.filmku.data.source.remote.response.tv.ResultTvShow
import com.dicoding.filmku.data.source.remote.response.tv.TvResponse
import com.dicoding.filmku.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getListMovies(): LiveData<ApiResponse<List<ResultMovie>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<ResultMovie>>>()
        ApiConfig.getApiService().getMovies(API_KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ){
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Succeed")
                    result.value = ApiResponse.success(response.body()?.results as List<ResultMovie>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(this@RemoteDataSource.toString(), "Get Movie Failed ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
        return result
    }

    fun getListTvShow(): LiveData<ApiResponse<List<ResultTvShow>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<ResultTvShow>>>()
        ApiConfig.getApiService().getTv(API_KEY)
            .enqueue(object : Callback<TvResponse> {
                override fun onResponse(
                    call: Call<TvResponse>,
                    response: Response<TvResponse>
                ){
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Succeed")
                    result.value = ApiResponse.success(response.body()?.results as List<ResultTvShow>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                    Log.e(this@RemoteDataSource.toString(), "Get Movie Failed ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getDetailMovies(id: Int): LiveData<ApiResponse<DetailMovieResults>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<DetailMovieResults>>()
        ApiConfig.getApiService().getDetailMovie(id, API_KEY)
            .enqueue(object : Callback<DetailMovieResults> {
                override fun onResponse(
                    call: Call<DetailMovieResults>,
                    response: Response<DetailMovieResults>
                ){
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Succeed")
                    result.value = ApiResponse.success(response.body() as DetailMovieResults)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<DetailMovieResults>, t: Throwable) {
                    Log.e(this@RemoteDataSource.toString(), "Get Movie Failed ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
        return result
    }

    fun getDetailTvShows(id: Int): LiveData<ApiResponse<DetailTvResults>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<DetailTvResults>>()
        ApiConfig.getApiService().getDetailTv(id, API_KEY)
            .enqueue(object : Callback<DetailTvResults> {
                override fun onResponse(
                    call: Call<DetailTvResults>,
                    response: Response<DetailTvResults>
                ){
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Succeed")
                    result.value = ApiResponse.success(response.body() as DetailTvResults)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<DetailTvResults>, t: Throwable) {
                    Log.e(this@RemoteDataSource.toString(), "Get Movie Failed ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
        return result
    }
}