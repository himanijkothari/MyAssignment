package com.example.myassignment.data.model

import androidx.compose.runtime.State
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult (
    val page: Int,
    val results : List<MultiSearchResult>,
    val total_results : Int,
    val total_pages: Int
)

@JsonClass(generateAdapter = true)
data class MultiSearchResult (
    val poster_path: String? = null,
    val adult: Boolean?,
    val gender: String?,
    val overview: String?,
    val release_date: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val media_type : String? = null,
    val original_title: String?,
    val original_language: String?,
    val title: String?,
    val backdrop_path: String? = null,
    val popularity: Double?,
    val vote_count: Int?,
    val video: Boolean?,
    val vote_average: Double?,
    val first_air_date: String?,
    val origin_country: List<String>?,
    val name: String?,
    val original_name: String?,
    val profile_path : String? = null,
    val known_for : List<KnownFor>?,
    val know_for_department : String?
)

@JsonClass(generateAdapter = true)
data class KnownFor(
    val poster_path: String? = null,
    val adult: Boolean?,
    val overview: String?,
    val release_date: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val media_type : String? = null,
    val original_title: String?,
    val original_language: String?,
    val title: String?,
    val backdrop_path: String? = null,
    val popularity: Double?,
    val vote_count: Int?,
    val video: Boolean?,
    val vote_average: Double?,
    val first_air_date: String?,
    val origin_country: List<String>?,
    val name: String?,
    val original_name: String?
)