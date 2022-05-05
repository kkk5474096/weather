package com.backpac.weather.data.datasource

import com.backpac.weather.data.model.response.ResponseLocal
import com.backpac.weather.data.model.response.ResponseWeather

interface WeatherDataSource {
    suspend fun getLocalList(): List<ResponseLocal>
    suspend fun getWeather(local: Int): ResponseWeather
}