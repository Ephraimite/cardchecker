package com.example.cardinfofinder.Models

import com.google.gson.annotations.SerializedName

class NumberInfo {
    @SerializedName("length")
    var length: Long? = null

    @SerializedName("luhn")
    var luhn: Boolean? = null

}