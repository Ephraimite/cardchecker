package com.example.cardinfofinder.Repositories

import com.example.cardinfofinder.Models.CardInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIinterface {
    @GET("/{cardBin}")
    fun getCardDetails(@Path("cardBin") cardBin: String?): Call<CardInfoResponse?>?
}