package com.example.crircket_compose.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//This is responsible for passing value from view to viewmodel i.e this controller
class HomeScreenControllerFactory(private val navController: NavController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        HomeScreenController(navController = navController) as T
}

// Controller for Home screen
//All logic will be written here
class HomeScreenController(val navController: NavController) : ViewModel() {

    //When user click on series button, it will navigate to select series type screen
    fun onSeriesButtonClick() {
        viewModelScope.launch {
            delay(400)
            navController.navigate("select_series_type_screen")
        }
    }

    //When user click on fixture button, it will navigate to fixture screen
    fun onFixtureButtonClick() {
        viewModelScope.launch {
            delay(400)
            navController.navigate("fixture_screen")
        }
    }

    //When user click on result button, it will navigate to result screen
    fun onResultButtonClick() {
        viewModelScope.launch {
            delay(400)
            navController.navigate("result_screen")
        }
    }
}