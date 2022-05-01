package com.example.myassignment.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TvShows (
    val page: Int,
    val results: List<TvShowDetail>,
    val total_results: Int,
    val total_pages: Int
)

@JsonClass(generateAdapter = true)
data class TvShowDetail (
    val poster_path: String? = null,
    val popularity: Double?,
    val id: Int?,
    val backdrop_path: String? = null,
    val vote_average: Double?,
    val media_type : String? = null,
    val overview: String?,
    val first_air_date: String?,
    val origin_country: List<String>?,
    val genre_ids : List<Int>?,
    val original_language: String?,
    val vote_count: Int?,
    val name: String?,
    val original_name: String?
)