package com.example.crircket_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.crircket_compose.navigation.MyNav
import com.example.crircket_compose.ui.theme.Crircket_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Crircket_composeTheme {
                MyNav()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Crircket_composeTheme {

    }
}