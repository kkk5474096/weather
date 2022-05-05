package com.backpac.weather.di

import com.backpac.weather.data.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)
}
