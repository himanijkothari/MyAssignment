package com.example.myassignment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import com.example.myassignment.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myassignment.MovieViewModel
import com.example.myassignment.data.model.Movies

import com.example.myassignment.data.model.TvShows
import com.example.myassignment.ui.theme.lightGray
import com.example.myassignment.ui.widget.TvDetailCard
import com.example.myassignment.ui.widget.topRatedMovieDetail
import com.example.myassignment.ui.widget.upcomingMovieDetails


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen( movieViewModel : MovieViewModel) {

    var keyword by remember { mutableStateOf("") }

    val keyboard = LocalSoftwareKeyboardController.current

    val topRatedMovie = produceState<Movies?>(initialValue = null) {
        value = movieViewModel.getTopRatedMovies()
    }

    val upcomingMovie = produceState<Movies?>(initialValue = null) {
        value = movieViewModel.getUpcomingMovies()
    }

    val popularTvShows = produceState<TvShows?>(initialValue = null) {
        value = movieViewModel.getPopularTvShows()
    }

    val topRatedTvShows = produceState<TvShows?>(initialValue = null) {
        value = movieViewModel.getTopRatedTvShows()
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
            .padding(top = 16.dp)
    ){
        TextField(
            value = keyword,
            onValueChange = {
                keyword = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 32.dp)
                .height(54.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.label_search_field_text),
                    fontSize = 14.sp
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        keyword = ""
                        keyboard?.hide()
                    }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = " Close icon",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.Black.copy(alpha = ContentAlpha.medium)
            ))

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.label_top_rated_movie),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
            }

            item {
                if (topRatedMovie.value != null) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(topRatedMovie.value!!.results) {
                            topRatedMovieDetail(it)
                        }
                    }
                }
            }

            item {
                Text(
                    text = stringResource(id = R.string.label_upcoming_movie),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
            }


            item {
                if (upcomingMovie.value != null) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(upcomingMovie.value!!.results) {
                            upcomingMovieDetails(it)
                        }
                    }
                }
            }

            item {
                Text(
                    text = stringResource(id = R.string.label_popular_tv_show),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
            }

            item {
                if (popularTvShows.value != null) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(popularTvShows.value!!.results) {
                            TvDetailCard(it)
                        }
                    }
                }
            }

            item {
                Text(
                    text = stringResource(id = R.string.label_top_rated_tv_show),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
            }

            item {
                if (topRatedTvShows.value != null) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(topRatedTvShows.value!!.results) {
                            TvDetailCard(it)
                        }
                    }
                }
            }
        }
    }


}