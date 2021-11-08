package com.example.crircket_compose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crircket_compose.models.Sery
import com.example.crircket_compose.screens.*


// this is responsible for handling all navigation in app
@Composable
fun MyNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("home_screen") {
            HomeScreen(navController = navController)
        }

        composable("select_series_type_screen") {
            SelectSeriesTypeScreen(navController = navController)
        }
        composable("series_screen") {
            val listOfSeries =
                navController.previousBackStackEntry?.savedStateHandle?.get<List<Sery>>("data")
            listOfSeries?.let {
                SeriesScreen(it, navController)
            }
        }
        composable("fixture_screen") {
            FixtureScreen(navController)
        }
        composable("result_screen") {
            ResultScreen(navController)
        }
    }
}