package com.example.crircket_compose.util

import com.example.crircket_compose.util.config.BASEURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFirInstance {
    companion object {

        fun getInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            var client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit
                .Builder()
                .baseUrl(BASEURL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}