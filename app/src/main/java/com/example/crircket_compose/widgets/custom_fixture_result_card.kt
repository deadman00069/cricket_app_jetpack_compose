package com.example.crircket_compose.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.crircket_compose.models.ListOfFixtureModel
import com.example.crircket_compose.util.KBackGroundColor

@Composable
fun CustomFixtureResultCard(data: ListOfFixtureModel) {
    androidx.compose.material.Card(
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
                data.match_title,
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            androidx.compose.material.Text(
                "at ${data.venue}",
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Divider(
                modifier = Modifier.padding(
                    vertical = 16.dp
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    data.away.name,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text("Vs")
                Text(
                    data.home.name,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center

                )
            }

            //result
            if (data.result != "") {
                Surface(
                    color = Color(KBackGroundColor),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Result",
                            style = MaterialTheme.typography.body2.copy(color = Color.Gray)
                        )
                        Text(
                            data.result,
                            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "Last updated",
                    style = MaterialTheme.typography.caption.copy(color = Color.Gray)
                )
                Text(
                    data.date,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
//
    }
}