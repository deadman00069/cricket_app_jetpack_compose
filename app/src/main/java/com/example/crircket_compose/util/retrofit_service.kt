package com.example.crircket_compose.util

import com.example.crircket_compose.models.FixtureResult
import com.example.crircket_compose.models.SeriesResult
import com.example.crircket_compose.util.config.KApiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface RetrofitService {

    //For getting series data
    @Headers(
        value = [
            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
            "x-rapidapi-key:$KApiKey"
        ]
    )
    @GET("series")
    suspend fun getSeries(): Response<SeriesResult>


    //For getting fixtures data
    @Headers(
        value = [
            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
            "x-rapidapi-key:$KApiKey"
        ]
    )
    @GET("fixtures")
    suspend fun getFixtures(): Response<FixtureResult>

//
//    //For getting fixtures data by date
//    @Headers(
//        value = [
//            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
//            "x-rapidapi-key:$KApiKey"
//        ]
//    )
//    @GET("fixtures-by-date/{date}")
//    suspend fun getFixturesByDate(@Path(value = "date") date: String)
//
//
//    //For getting fixtures data by series id
//    @Headers(
//        value = [
//            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
//            "x-rapidapi-key:$KApiKey"
//        ]
//    )
//    @GET("fixtures-by-series/{series}")
//    suspend fun getFixturesBySeries(@Path(value = "series") series: String)


    //For getting results
    @Headers(
        value = [
            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
            "x-rapidapi-key:$KApiKey"
        ]
    )
    @GET("results")
    suspend fun getResults(): Response<FixtureResult>


//    //For getting result data by date
//    @Headers(
//        value = [
//            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
//            "x-rapidapi-key:$KApiKey"
//        ]
//    )
//    @GET("results-by-date/{date}")
//    suspend fun getResultByDate(@Path(value = "date") date: String)
//
//
//    //For getting match score data
//    @Headers(
//        value = [
//            "x-rapidapi-host:cricket-live-data.p.rapidapi.com",
//            "x-rapidapi-key:$KApiKey"
//        ]
//    )
//    @GET("match/{match_id}")
//    suspend fun getMatchScoreCard(@Path(value = "match_id") matchId: String)
}