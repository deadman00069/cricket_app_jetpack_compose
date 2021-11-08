package com.example.crircket_compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crircket_compose.models.Sery
import com.example.crircket_compose.util.KBackGroundColor
import com.example.crircket_compose.widgets.CustomTopAppBar

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

                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column() {
                                Text(
                                    "Status",
                                    style = androidx.compose.material.MaterialTheme.typography.body1.copy(
                                        fontWeight = FontWeight.W500
                                    )
                                )
                                Text(
                                    list[index].status,
                                    style = androidx.compose.material.MaterialTheme.typography.caption.copy(
                                        fontWeight = FontWeight.Light,
                                        color = Color.Gray
                                    )
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Season",
                                    style = androidx.compose.material.MaterialTheme.typography.body1.copy(
                                        fontWeight = FontWeight.W500
                                    )
                                )
                                Text(
                                    list[index].season,
                                    style = androidx.compose.material.MaterialTheme.typography.caption.copy(
                                        fontWeight = FontWeight.Light,
                                        color = Color.Gray
                                    )
                                )

                            }
                        }
                        Spacer(
                            modifier = Modifier.height(
                                8.dp
                            )
                        )
                        Text(
                            list[index].series_name,
                            style = androidx.compose.material.MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun d2() {
//    SeriesScreen()
//}