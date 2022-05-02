package com.example.myassignment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myassignment.ui.navigation.MovieNavGraph


@Composable
fun MovieAppContent(
    movieViewModel: MovieViewModel
){

    val navController = rememberNavController()
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.height(88.dp),
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp,
                ) {
                Column {
                    AppBar(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    MenuBar(navController)
                }
            }
        }
    ) {
        MovieNavGraph(navController, movieViewModel)
    }
}

@Composable
fun AppBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(id = R.string.label_movie_finder),
            modifier = Modifier.clickable { navController.navigate(Home.route) },
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )

        Button(
            onClick = { navController.navigate(SignIn.route) },
            modifier = Modifier.size(95.dp,40.dp),
            shape = RoundedCornerShape(25),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ){
            Text(
                text = stringResource(id = R.string.label_sign_in),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MenuBar(navController : NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ){
        Row( modifier = Modifier.weight(1f)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_movie_48px),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            MenuBarItem(
                text = stringResource(id = R.string.label_movies),
                onClick = { navController.navigate(Movies.route) }
            )
        }

        Row( modifier = Modifier.weight(1f)){
            Icon(
                painter = painterResource(id = R.drawable.television),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            MenuBarItem(
                text = stringResource(id = R.string.label_tv_shows),
                //modifier = Modifier.weight(1f),
                onClick = { navController.navigate(TVShows.route)}
            )
        }

        Row( modifier = Modifier.weight(1f)){
            Icon(
                painter = painterResource(id = R.drawable.culture_cinema),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            MenuBarItem(
                text = stringResource(id = R.string.label_actors),
                //modifier = Modifier.weight(1f),
                onClick = {navController.navigate(Actors.route) }
            )
        }
    }
}

@Composable
fun MenuBarItem(
    text: String,
    onClick : ()  -> Unit,
) {
    Text(
        text = text,
        modifier = Modifier
            .padding(5.dp)
            .clickable { onClick() },
        color = Color.Black,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}