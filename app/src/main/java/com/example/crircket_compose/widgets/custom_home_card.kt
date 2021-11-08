package com.example.crircket_compose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomHomeCard(text: String, color1: Long, color2: Long, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(color1),
                        Color(color2),

                        )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            }
    ) {
        Text(
            text,
            style = MaterialTheme.typography.h6.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}