package com.example.crircket_compose.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.crircket_compose.R
import com.example.crircket_compose.controller.HomeScreenController
import com.example.crircket_compose.controller.HomeScreenControllerFactory
import com.example.crircket_compose.widgets.CustomHomeCard

@Composable
fun HomeScreen(navController: NavController) {

    val controller: HomeScreenController =
        viewModel(factory = HomeScreenControllerFactory(navController = navController))
    val context = LocalContext.current as Activity
    BackHandler(enabled = true) {
        context.finish()
    }
    Scaffold(
        backgroundColor = White
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Image(
                    painter = painterResource(id = R.drawable.cricket),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    "CRICKET",
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            CustomHomeCard(
                text = "Series",
                color1 = 0xffAD54D0,
                color2 = 0xff531EF3
            )
            {
                controller.onSeriesButtonClick()
            }
            CustomHomeCard(
                text = "Fixtures",
                color1 = 0xffEFBC44,
                color2 = 0xffF47107
            ) {
                controller.onFixtureButtonClick()
            }
            CustomHomeCard(
                text = "Results",
                color1 = 0xffED69A5,
                color2 = 0xffEFC15E
            ) {
                controller.onResultButtonClick()
            }

        }
    }
}
