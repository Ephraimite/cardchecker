package com.example.cardinfofinder.Repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://lookup.binlist.net/"
    var retrofit: Retrofit? = null
    @JvmStatic
    val client: Retrofit? get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
}