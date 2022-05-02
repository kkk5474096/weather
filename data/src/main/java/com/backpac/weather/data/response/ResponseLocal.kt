package com.backpac.weather.data.response

import com.google.gson.annotations.SerializedName

data class ResponseLocal(
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("woeid")
    val woeId: Int,
    @SerializedName("latt_long")
    val latLong: String

)