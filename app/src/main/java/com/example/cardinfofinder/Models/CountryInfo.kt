package com.example.cardinfofinder.Models

import com.google.gson.annotations.SerializedName

class CountryInfo {
    @SerializedName("alpha2")
    var alpha2: String? = null

    @SerializedName("currency")
    var currency: String? = null

    @SerializedName("emoji")
    var emoji: String? = null

    @SerializedName("latitude")
    var latitude: Long? = null

    @SerializedName("longitude")
    var longitude: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("numeric")
    var numeric: String? = null

}