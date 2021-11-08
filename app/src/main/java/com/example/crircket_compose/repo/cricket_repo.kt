package com.example.crircket_compose.repo

import com.example.crircket_compose.models.FixtureResult
import com.example.crircket_compose.models.SeriesResult
import com.example.crircket_compose.util.RetroFirInstance
import com.example.crircket_compose.util.RetrofitService
import retrofit2.Response


//This class is responsible for handling all api call and returning response of type Response
class CricketApiRepo {

    suspend fun getSeriesRepo(): Response<SeriesResult> {
        val retroFitInstance = RetroFirInstance.getInstance().create(RetrofitService::class.java)
        return retroFitInstance.getSeries()
    }

    suspend fun getFixtureRepo(): Response<FixtureResult> {
        val retroFitInstance = RetroFirInstance.getInstance().create(RetrofitService::class.java)
        return retroFitInstance.getFixtures()
    }

    suspend fun getResultRepo(): Response<FixtureResult> {
        val retroFitInstance = RetroFirInstance.getInstance().create(RetrofitService::class.java)
        return retroFitInstance.getResults()
    }
}