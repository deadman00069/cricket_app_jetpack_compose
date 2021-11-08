package com.example.crircket_compose.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class SeriesResult(val results: List<ListOfSeriesModel>)

data class ListOfSeriesModel(
    val series: List<Sery>,
    val type: String
)

@Parcelize
data class Sery(
    val season: String,
    val series_id: Int,
    val series_name: String,
    val status: String,
    val updated_at: String
) : Parcelable