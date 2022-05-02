package com.example.myassignment.data.controller

import com.example.myassignment.data.model.Movies
import com.example.myassignment.data.model.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieController {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(@Query("language") language: String, @Query("page") page: Int) : Response<Movies>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("language") language: String, @Query("page") page: Int): Response<Movies>

    @GET("search/multi")
    suspend fun searchForMultiResult(@Query("language") language: String, @Query("query") query: String, @Query("page") page: Int): Response<SearchResult>

    @GET("discover/movie")
    suspend fun getMoviesByGenre(@Query("language") language: String,@Query("with_genres") genre: String) : Response<Movies>

}