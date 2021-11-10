package com.example.crircket_compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crircket_compose.models.Sery
import com.example.crircket_compose.util.KBackGroundColor
import com.example.crircket_compose.widgets.CustomTopAppBar
import com.example.crircket_compose.widgets.SeriesCard

@Composable
fun SeriesScreen(list: List<Sery>, navController: NavController) {

    Scaffold(
        backgroundColor = Color(KBackGroundColor),
        topBar = {
            CustomTopAppBar {
                navController.popBackStack()
            }
        }

    ) {
        LazyColumn() {
            item {
                Text(
                    "All Series",
                    style = androidx.compose.material.MaterialTheme
                        .typography.h6.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    modifier = Modifier.padding(
                        top = 32.dp,
                        start = 16.dp,
                        bottom = 16.dp
                    )
                )
            }
            items(count = list.size)
            { index ->

                SeriesCard(list[index])
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun d2() {
//    SeriesScreen()
//}