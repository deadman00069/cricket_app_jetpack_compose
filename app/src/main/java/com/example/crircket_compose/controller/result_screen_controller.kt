package com.example.crircket_compose.controller

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.crircket_compose.models.ListOfFixtureModel
import com.example.crircket_compose.repo.CricketApiRepo
import kotlinx.coroutines.launch

//This is responsible for passing value from view to viewmodel i.e this controller
class ResultScreenControllerFactory(private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ResultScreenController(context) as T
}

// Controller for Result screen
//All logic will be written here
class ResultScreenController(private val context: Context) : ViewModel() {

    val listOfResults = mutableListOf<ListOfFixtureModel>()
    val isLoading = mutableStateOf(false)

    init {
        viewModelScope.launch {
            getResults()
        }
    }

    private suspend fun getResults() {
        isLoading.value = true
        val repo = CricketApiRepo()
        val response = repo.getResultRepo()
        if (response.isSuccessful) {
            response.body()!!.results.forEach {
                listOfResults.add(it)
            }
            isLoading.value = false
        } else {
            Toast.makeText(
                context,
                "Something went wrong,please try again later",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}