package com.backpac.weather.domain.repository

import com.backpac.weather.domain.entity.Local
import com.backpac.weather.domain.entity.Weather

interface WeatherRepository {
    suspend fun getLocalList(): List<Local>
    suspend fun getWeather(local: Int): Weather
}