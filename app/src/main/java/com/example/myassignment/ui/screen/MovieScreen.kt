package com.example.myassignment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myassignment.MovieViewModel
import com.example.myassignment.data.model.Movies
import com.example.myassignment.ui.widget.topRatedMovieDetail


@Composable
fun  MovieScreen( movieViewModel: MovieViewModel ) {

    val genre1Movies = produceState<Movies?>(initialValue = null){
        value =  movieViewModel.getMovieByGenre(28)
    }

    val genre2Movies = produceState<Movies?>(initialValue = null){
        value =  movieViewModel.getMovieByGenre(35)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)

    ) {
        Text(
            text = "Action",
            modifier = Modifier.padding(start = 8.dp),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2
        )

        if(genre1Movies.value != null){
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(genre1Movies.value!!.results) {
                    topRatedMovieDetail(it)
                }
            }
        }

        Text(
            text = "Comedy",
            modifier = Modifier.padding(start = 8.dp),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2
        )

        if(genre2Movies.value != null){
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(genre2Movies.value!!.results) {
                    topRatedMovieDetail(it)
                }
            }
        }
    }
}
