package com.example.crircket_compose.controller

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.crircket_compose.models.ListOfFixtureModel
import com.example.crircket_compose.repo.CricketApiRepo
import kotlinx.coroutines.launch


//This is responsible for passing value from view to viewmodel i.e this controller
class FixtureScreenFactory(private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        FixtureScreenController(context) as T
}


// Controller for Fixture screen
//All logic will be written here
class FixtureScreenController(private val context: Context) : ViewModel() {

    val listOfFixture = mutableListOf<ListOfFixtureModel>()
    val isLoading = mutableStateOf(false)

    init {
        viewModelScope.launch {
            getFixture()
        }
    }


    //This function is responsible for getting data from repo and then show the received data on screen
    private suspend fun getFixture() {
        isLoading.value = true
        val repo = CricketApiRepo()
        val response = repo.getFixtureRepo()
        if (response.isSuccessful) {
            response.body()!!.results.forEach {
                listOfFixture.add(it)
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