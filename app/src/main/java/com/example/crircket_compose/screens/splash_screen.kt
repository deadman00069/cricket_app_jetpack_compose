package com.example.crircket_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.crircket_compose.R
import com.example.crircket_compose.controller.SelectSeriesScreenController
import com.example.crircket_compose.controller.SplashScreenController
import com.example.crircket_compose.controller.SplashScreenControllerFactory
import com.example.crircket_compose.util.KBackGroundColor

@Composable
fun SplashScreen(navController: NavController) {
    val controller: SplashScreenController =
        viewModel(factory = SplashScreenControllerFactory(navController = navController))

    Scaffold(
        backgroundColor = Color(KBackGroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.first),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "MyCricketApp",
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
            )

        }
    }
}
