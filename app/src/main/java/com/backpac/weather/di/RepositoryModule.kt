package com.backpac.weather.di

import com.backpac.weather.data.repository.WeatherRepositoryImpl
import com.backpac.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherRepository: WeatherRepositoryImpl
    ): WeatherRepository = weatherRepository
}