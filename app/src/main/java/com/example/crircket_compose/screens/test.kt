package com.example.crircket_compose.screens


import android.os.Build
import android.widget.Space
import androidx.annotation.RequiresApi
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
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

@Composable
fun testScreen() {


    Scaffold(
        backgroundColor = Color(KBackGroundColor),
        topBar = {
            TopAppBar(
                backgroundColor = Color(KBackGroundColor),
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                title = {}
            )
        }
    ) {
        LazyColumn() {
            item {
                Text(
                    " sdfds",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 32.dp, start = 16.dp, bottom = 16.dp)
                )
            }
            items(count = 20) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            "Title is this",
                            style = MaterialTheme.typography.body2.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            "at Title is Venue",
                            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Divider(modifier = Modifier.padding(vertical = 16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Tam1",
                                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                            )
                            Text("Vs")
                            Text(
                                "Tam2",
                                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        androidx.compose.material.Surface(
                            color = Color(KBackGroundColor)
                        ) {
                            Text("Thu,28,2021,3:30 IST", modifier = Modifier.padding(8.dp))
                        }
                    }
//
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun dTest() {
    testScreen()
}