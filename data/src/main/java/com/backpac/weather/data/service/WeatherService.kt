package com.backpac.weather.data.service

import com.backpac.weather.data.model.response.ResponseLocal
import com.backpac.weather.data.model.response.ResponseWeather
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("search/?query=se")
    suspend fun getLocalList(): List<ResponseLocal>

    @GET("{woeid}")
    suspend fun getWeather(
        @Path("woeid") woeid: Int
    ): ResponseWeather
}