package com.example.crircket_compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crircket_compose.controller.SelectSeriesScreenController
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.crircket_compose.controller.SelectSeriesScreenControllerFactory
import com.example.crircket_compose.util.KBackGroundColor
import com.example.crircket_compose.widgets.CustomTopAppBar

@Composable
fun SelectSeriesTypeScreen(navController: NavController) {
    val context = LocalContext.current
    val controller: SelectSeriesScreenController =
        viewModel(factory = SelectSeriesScreenControllerFactory(context = context))

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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Text(
                        "Please select series type",
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 32.dp, start = 16.dp, bottom = 16.dp)
                    )
                }
                items(count = controller.lisOfSeries.size) { index ->


                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "data",
                                    controller.lisOfSeries[index].series
                                )
                                navController.navigate("series_screen")
                            }
                    ) {
                        Text(
                            controller.lisOfSeries[index].type, modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body1.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
                            )
                        )
                    }
                }
            }
        }
    }
}
