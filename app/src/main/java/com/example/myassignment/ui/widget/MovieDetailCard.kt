package com.example.myassignment.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.myassignment.data.model.MovieDetailClass
import com.example.myassignment.ui.theme.golden

private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

@Composable
fun topRatedMovieDetail(movie: MovieDetailClass) {

    Column(
        modifier = Modifier.size(150.dp,200.dp)
    ) {
        Box(
            modifier = Modifier.size(150.dp,150.dp),
            contentAlignment = Alignment.TopEnd
        ){
            Image(
                painter = rememberAsyncImagePainter(IMAGE_URL + movie.poster_path),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp,14.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(25)),
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = golden
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = movie.vote_average.toString(),
                    fontSize = 12.sp

                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        movie.original_title?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                style = MaterialTheme.typography.h2
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            movie.release_date?.substring(0,4)?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Composable
fun upcomingMovieDetails(upcomingMovie : MovieDetailClass){

    Column(
        modifier = Modifier.size(150.dp,200.dp)
    ) {
        Box(
            modifier = Modifier.size(150.dp,150.dp)
        ){
            Image(
                painter = rememberAsyncImagePainter(IMAGE_URL + upcomingMovie.poster_path),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        upcomingMovie.original_title?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                style = MaterialTheme.typography.h2
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            upcomingMovie.release_date?.substring(0,4)?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }

}