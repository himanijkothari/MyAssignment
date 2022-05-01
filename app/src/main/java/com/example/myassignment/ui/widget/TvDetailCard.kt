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
import com.example.myassignment.data.model.TvShowDetail
import com.example.myassignment.ui.theme.golden

private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

@Composable
fun TvDetailCard(tvShows: TvShowDetail) {
    Column(
        modifier = Modifier.size(150.dp, 200.dp)
    ) {
        Box(
            modifier = Modifier.size(150.dp, 150.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = rememberAsyncImagePainter(IMAGE_URL + tvShows.poster_path),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp, 14.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(25)),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = golden
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = tvShows.vote_average.toString(),
                    fontSize = 12.sp

                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        tvShows.original_name?.let {
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
            tvShows.first_air_date?.let {
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