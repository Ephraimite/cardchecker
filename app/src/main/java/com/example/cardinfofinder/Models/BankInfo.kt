package com.example.cardinfofinder.Models

import com.google.gson.annotations.SerializedName

class BankInfo {
    @SerializedName("city")
    var city: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("phone")
    var phone: String? = null

    @SerializedName("url")
    var url: String? = null

}