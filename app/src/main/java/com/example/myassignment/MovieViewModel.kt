package com.example.myassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment.data.controller.MovieController
import com.example.myassignment.data.controller.TvShowController
import com.example.myassignment.data.model.TvShows
import com.example.myassignment.data.model.Movies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieController: MovieController,
    private val tvShowController: TvShowController
): ViewModel() {

    suspend fun getTopRatedMovies() : Movies? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            val response = movieController.getTopRatedMovie("en-US",(1..5).random())
            if(response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }

    suspend fun getUpcomingMovies() : Movies? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            val response = movieController.getUpcomingMovie("en-US",(1..5).random())
            if(response.isSuccessful){
                response.body()
            } else {
                null
            }
        }

    suspend fun getPopularTvShows() : TvShows? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            val response = tvShowController.getPopularTvShows("en-US",(1..5).random())
            if(response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }

    suspend fun getTopRatedTvShows() : TvShows? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            val response = tvShowController.getTopRatedTvShows("en-US",(1..5).random())
            if(response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
}