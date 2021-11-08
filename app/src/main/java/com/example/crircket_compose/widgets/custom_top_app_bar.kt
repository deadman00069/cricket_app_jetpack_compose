package com.example.crircket_compose.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.crircket_compose.util.KBackGroundColor

@Composable
fun CustomTopAppBar(
    onclick: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color(KBackGroundColor),
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                onclick.invoke()
            }) {
                Icon(Icons.Default.ArrowBack, null)
            }
        },
        title = {}
    )
}