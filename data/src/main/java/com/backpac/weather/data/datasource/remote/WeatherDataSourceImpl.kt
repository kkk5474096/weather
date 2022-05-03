package com.backpac.weather.data.remote

import com.backpac.weather.data.datasource.WeatherDataSource
import com.backpac.weather.data.model.response.ResponseLocal
import com.backpac.weather.data.model.response.ResponseWeather
import com.backpac.weather.data.service.WeatherService
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    private val service: WeatherService
): WeatherDataSource {
    override suspend fun getLocalList(): List<ResponseLocal> {
        return service.getLocalList()
    }

    override suspend fun getWeather(local: Int): ResponseWeather {
        return service.getWeather(local)
    }
}