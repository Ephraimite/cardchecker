package com.example.cardinfofinder.Models

import com.example.cardinfofinder.Models.BankInfo
import com.example.cardinfofinder.Models.CountryInfo
import com.google.gson.annotations.SerializedName

class CardInfoResponse {
    @SerializedName("bank")
    private var mBank: BankInfo? = null

    @SerializedName("brand")
    private var mBrand: String? = null

    @SerializedName("country")
    private var mCountryInfo: CountryInfo? = null

    @SerializedName("type")
    private var mType: String? = null
    fun getmBank(): BankInfo? {
        return mBank
    }

    fun setmBank(mBank: BankInfo?) {
        this.mBank = mBank
    }

    fun getmBrand(): String? {
        return mBrand
    }

    fun setmBrand(mBrand: String?) {
        this.mBrand = mBrand
    }

    fun getmCountryInfo(): CountryInfo? {
        return mCountryInfo
    }

    fun setmCountryInfo(mCountryInfo: CountryInfo?) {
        this.mCountryInfo = mCountryInfo
    }

    fun getmType(): String? {
        return mType
    }

    fun setmType(mType: String?) {
        this.mType = mType
    }
}