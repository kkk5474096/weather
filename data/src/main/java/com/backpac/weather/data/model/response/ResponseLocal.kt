package com.backpac.weather.data.model.response

import com.backpac.weather.domain.entity.Local
import com.google.gson.annotations.SerializedName

data class ResponseLocal(
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("woeid")
    val woeId: Int,
    @SerializedName("latt_long")
    val latLong: String
) {
    fun toLocal(): Local {
        return Local(title, locationType, woeId, latLong)
    }
}