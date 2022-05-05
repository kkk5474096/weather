package com.backpac.weather.domain.entity

data class Weather(
    val title: String,
    val consolidatedWeather: List<WeatherDetail>
)

data class WeatherDetail(
    val weatherStateName: String,
    val weatherStateAbbr: String,
    val theTemp: Double,
    val humidity: Int
)