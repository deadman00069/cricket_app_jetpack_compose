package com.example.crircket_compose.models

data class FixtureResult(val results: List<ListOfFixtureModel>)

data class ListOfFixtureModel(
    val away: Away,
    val date: String,
    val home: Home,
    val id: Int,
    val match_subtitle: String,
    val match_title: String,
    val result: String,
    val series_id: Int,
    val status: String,
    val venue: String
)

data class Away(
    val code: String,
    val id: Int,
    val name: String
)

data class Home(
    val code: String,
    val id: Int,
    val name: String
)