package com.example.crircket_compose.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//This is responsible for passing value from view to viewmodel i.e this controller
class SplashScreenControllerFactory(private val navController: NavController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        SplashScreenController(navController = navController) as T
}

// Controller for SplashScreen screen
//All logic will be written here
class SplashScreenController(navController: NavController) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(3000L)
            navController.navigate("home_screen")
        }
    }
}