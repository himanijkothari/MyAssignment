package com.example.myassignment.data.controller

import com.example.myassignment.data.model.TvShows
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowController {

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("language") language: String, @Query("page") page: Int) : Response<TvShows>

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(@Query("language") language: String, @Query("page") page: Int) : Response<TvShows>

}