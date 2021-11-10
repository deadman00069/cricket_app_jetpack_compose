package com.example.crircket_compose.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.crircket_compose.models.Sery
import java.text.SimpleDateFormat

@Composable
fun SeriesCard(data: Sery) {

    val date = data.updated_at
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")
    val parsedDate = inputFormat.parse(date)
    val formattedDate = outputFormat.format(parsedDate)


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
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.W500
                        )
                    )
                    Text(
                        data.status,
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.Light,
                            color = Color.Gray
                        )
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Season",
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.W500
                        )
                    )
                    Text(
                        data.season,
                        style = MaterialTheme.typography.caption.copy(
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
                data.series_name,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.height(
                    8.dp
                )
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(1.dp))
                Column() {
                    Text(
                        "Last updated",
                        style = MaterialTheme.typography.caption.copy(color = Color.Gray)
                    )
                    Text(
                        formattedDate,
                        style = MaterialTheme.typography.caption.copy(color = Color.Black)
                    )
                }
            }
        }
    }
}