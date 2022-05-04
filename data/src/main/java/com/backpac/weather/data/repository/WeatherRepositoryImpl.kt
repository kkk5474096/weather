package com.backpac.weather.data.repository

import com.backpac.weather.data.datasource.WeatherDataSource
import com.backpac.weather.domain.entity.Local
import com.backpac.weather.domain.entity.Weather
import com.backpac.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val dataSource: WeatherDataSource
): WeatherRepository {
    override suspend fun getLocalList(): List<Local> {
        return dataSource.getLocalList().map {
            it.toLocal()
        }
    }

    override suspend fun getWeather(local: Int): Weather {
        return dataSource.getWeather(local).toWeather()
    }
}