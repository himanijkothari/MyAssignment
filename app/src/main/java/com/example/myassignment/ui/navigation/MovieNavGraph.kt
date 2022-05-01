package com.example.myassignment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myassignment.*
import com.example.myassignment.ui.screen.*

@Composable
fun MovieNavGraph(
    navController: NavHostController,
    movieViewModel: MovieViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(
            Home.route,
            arguments = Home.arguments
        ) {
            HomeScreen(
                movieViewModel = movieViewModel
            )
        }
        composable(
            Movies.route,
            arguments = Movies.arguments
        ) {
            MovieScreen()
        }
        composable(
            SignIn.route,
            arguments = SignIn.arguments
        ) {
            SignInScreen()
        }
        composable(
            TVShows.route,
            arguments = TVShows.arguments
        ) {
            TvShowScreen()
        }
        composable(
            Actors.route
        ) {
            ActorScreen()
        }
    }
}