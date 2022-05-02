package com.backpac.weather.data.response

import com.google.gson.annotations.SerializedName

data class ResponseWeather(
    @SerializedName("consolidated_weather")
    val consolidated_weather: List<ResponseWeatherDetail>,
    val title: String
) {
    data class ResponseWeatherDetail(
        @SerializedName("weather_state_name")
        val weatherStateName: String,
        @SerializedName("weather_state_abbr")
        val weatherStateAbbr: String,
        @SerializedName("the_temp")
        val theTemp: Double,
        @SerializedName("humidity")
        val humidity: Int
    )
}