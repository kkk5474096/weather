package com.backpac.weather.di

import com.backpac.weather.data.datasource.WeatherDataSource
import com.backpac.weather.data.datasource.remote.WeatherDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideWeatherDataSource(
        weatherDataSource: WeatherDataSourceImpl
    ): WeatherDataSource = weatherDataSource
}