package com.backpac.weather.data.model.response

import com.backpac.weather.domain.entity.Weather
import com.backpac.weather.domain.entity.WeatherDetail
import com.google.gson.annotations.SerializedName

data class ResponseWeather(
    val title: String,
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ResponseWeatherDetail>
) {
    fun toWeather(): Weather {
        return Weather(title, consolidatedWeather.map {
            WeatherDetail(it.weatherStateName, it.weatherStateAbbr, it.theTemp, it.humidity)
        })
    }
}

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