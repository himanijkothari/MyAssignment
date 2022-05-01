package com.example.myassignment

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
)

object Home: Screen(
    route = "home"
)

object Movies: Screen(
    route = "movies"
)

object TVShows: Screen(
    route = "tvshows"
)

object Actors: Screen(
    route = "actors"
)

object SignIn: Screen(
    route = "Signin"
)