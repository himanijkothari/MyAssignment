package com.example.myassignment.data.controller


import com.example.myassignment.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieController {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(@Query("language") language: String, @Query("page") page: Int) : Response<Movies>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("language") language: String, @Query("page") page: Int): Response<Movies>

}