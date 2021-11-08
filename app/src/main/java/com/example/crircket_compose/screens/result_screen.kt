package com.example.crircket_compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.crircket_compose.controller.ResultScreenController
import com.example.crircket_compose.controller.ResultScreenControllerFactory
import com.example.crircket_compose.util.KBackGroundColor
import com.example.crircket_compose.widgets.CustomFixtureResultCard
import com.example.crircket_compose.widgets.CustomTopAppBar

@Composable
fun ResultScreen(navController: NavController) {
    val context = LocalContext.current
    val controller: ResultScreenController =
        viewModel(factory = ResultScreenControllerFactory(context = context))
    Scaffold(
        backgroundColor = Color(KBackGroundColor),
        topBar = {
            CustomTopAppBar {
                navController.popBackStack()

            }
        }
    ) {
        if (controller.isLoading.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn() {
                item {
                    Text(
                        "Results",
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 16.dp)
                    )
                }
                items(count = controller.listOfResults.size) { index ->
                    CustomFixtureResultCard(data = controller.listOfResults[index])
                }
            }
        }
    }
}