package com.example.androidbasictoadvanced.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    val api: ApiService2 by lazy {
        // lazy means: Don't create this object until it is actually needed.
        Retrofit.Builder()
            /**
             * This starts the process of configuring Retrofit.
             * "Think! I want to create a Retrofit client."
             */
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService2::class.java)

    }
}