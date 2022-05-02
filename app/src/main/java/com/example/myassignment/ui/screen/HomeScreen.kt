package com.example.myassignment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import com.example.myassignment.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myassignment.MovieViewModel
import com.example.myassignment.data.model.MovieDetailClass
import com.example.myassignment.data.model.Movies
import com.example.myassignment.data.model.TvShowDetail
import com.example.myassignment.data.model.SearchResult
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

    val searchSubmitted = remember { mutableStateOf(false) }

    val showDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
            .padding(top = 16.dp)
    ) {
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
                    onClick = {
                        searchSubmitted.value = true
                        keyboard?.hide()
                  },
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
                        searchSubmitted.value = false
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
                onSearch = {
                    searchSubmitted.value = true
                    keyboard?.hide()
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.Black.copy(alpha = ContentAlpha.medium)
            ))

        if (keyword == "") {
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
        } else if (searchSubmitted.value) {

            keyword = keyword.trimStart()

            if(isKeyWordValid(keyword)){
                val homeSearchResult = produceState<SearchResult?>(initialValue = null) {
                    value = movieViewModel.getMultiSearchResult(keyword)
                }
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ){
                    item {
                        Text(
                            text = stringResource(id = R.string.label_movies),
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h2
                        )
                    }

                    item {
                        if (homeSearchResult.value != null) {
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(8.dp),
                               // horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(homeSearchResult.value!!.results) {
                                    if (it.media_type == "movie") {
                                        topRatedMovieDetail( MovieDetailClass(
                                            it.poster_path,
                                            it.adult,
                                            it.overview,
                                            it.release_date,
                                            it.genre_ids,
                                            it.id,
                                            it.media_type,
                                            it.original_title,
                                            it.original_language,
                                            it.title,
                                            it.backdrop_path,
                                            it.popularity,
                                            it.vote_count,
                                            it.video,
                                            it.vote_average
                                        ))
                                    }
                                }
                            }
                        }
                    }

                    item {
                        Text(
                            text = stringResource(id = R.string.label_tv_shows),
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h2
                        )

                    }

                    item {
                        if (homeSearchResult.value != null) {
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(8.dp),
                                //horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(homeSearchResult.value!!.results) {
                                    if (it.media_type == "tv") {
                                        TvDetailCard(
                                            TvShowDetail(
                                                it.poster_path,
                                                it.popularity,
                                                it.id,
                                                it.backdrop_path,
                                                it.vote_average,
                                                it.media_type,
                                                it.overview,
                                                it.first_air_date,
                                                it.origin_country,
                                                it.genre_ids,
                                                it.original_language,
                                                it.vote_count,
                                                it.name,
                                                it.original_name
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }

                    item {
                        Text(
                            text = "Person with $keyword in the name",
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h2
                        )
                    }

                    item {
                        if (homeSearchResult.value != null) {
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(8.dp),
                               // horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(homeSearchResult.value!!.results) {
                                    if (it.media_type == "person") {
                                        if(it.known_for != null){
                                            it.known_for.forEach {
                                                if(it.media_type == "movie"){
                                                    topRatedMovieDetail( MovieDetailClass(
                                                        it.poster_path,
                                                        it.adult,
                                                        it.overview,
                                                        it.release_date,
                                                        it.genre_ids,
                                                        it.id,
                                                        it.media_type,
                                                        it.original_title,
                                                        it.original_language,
                                                        it.title,
                                                        it.backdrop_path,
                                                        it.popularity,
                                                        it.vote_count,
                                                        it.video,
                                                        it.vote_average
                                                    )
                                                    )
                                                }
                                                else if(it.media_type == "tv"){
                                                    TvDetailCard(
                                                        TvShowDetail(
                                                            it.poster_path,
                                                            it.popularity,
                                                            it.id,
                                                            it.backdrop_path,
                                                            it.vote_average,
                                                            it.media_type,
                                                            it.overview,
                                                            it.first_air_date,
                                                            it.origin_country,
                                                            it.genre_ids,
                                                            it.original_language,
                                                            it.vote_count,
                                                            it.name,
                                                            it.original_name
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                showDialog.value = true
            }

            if(showDialog.value)
            {
                AlertDialog(
                    onDismissRequest = {
                        showDialog.value = false
                    },
                    modifier = Modifier
                        .size(250.dp, 200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    text = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Keyword is not valid",
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                    },
                    buttons = {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    showDialog.value = false
                                    keyword = ""
                                },
                                modifier = Modifier
                                    .fillMaxWidth(),
                            ) {
                                Text(
                                    text = "OK",
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.button
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

public fun isKeyWordValid (keyword : String) : Boolean {
    val regex = Regex("^.*[a-zA-Z0-9]+.*$")
    return keyword.matches(regex)
}