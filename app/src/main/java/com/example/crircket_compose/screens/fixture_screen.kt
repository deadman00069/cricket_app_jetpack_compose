package com.example.crircket_compose.screens

import android.os.Build
import androidx.annotation.RequiresApi
import  androidx.compose.material.CircularProgressIndicator
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crircket_compose.util.KBackGroundColor
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.material.Divider
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.crircket_compose.controller.FixtureScreenController
import com.example.crircket_compose.controller.FixtureScreenFactory
import com.example.crircket_compose.widgets.CustomFixtureResultCard
import com.example.crircket_compose.widgets.CustomTopAppBar
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun FixtureScreen(navController: NavController) {
    val context = LocalContext.current
    val controller: FixtureScreenController =
        viewModel(factory = FixtureScreenFactory(context = context))

    Scaffold(
        backgroundColor = Color(KBackGroundColor),
        topBar = {
            CustomTopAppBar() {
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
                        "All Fixtures",
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 16.dp)
                    )
                }
                items(count = controller.listOfFixture.size) { index ->
                    CustomFixtureResultCard(data = controller.listOfFixture[index])
                }
            }
        }
    }
}
