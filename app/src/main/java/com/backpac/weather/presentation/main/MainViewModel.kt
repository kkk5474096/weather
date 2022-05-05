package com.backpac.weather.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backpac.weather.domain.entity.Weather
import com.backpac.weather.domain.entity.WeatherDetail
import com.backpac.weather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _weatherResultList = MutableLiveData<List<Weather>>()
    val weatherResultList: LiveData<List<Weather>> = _weatherResultList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getWeather() {
        var weatherDetailList: MutableList<WeatherDetail>
        val weatherResult: MutableList<Weather> = mutableListOf()
        viewModelScope.launch {
            _isLoading.value = true
            val localList = repository.getLocalList().map {
                viewModelScope.async { repository.getWeather(it.woeId) }
            }.awaitAll()
            localList.forEach {
                weatherDetailList = mutableListOf()
                it.consolidatedWeather.take(2).forEach { response ->
                    weatherDetailList.add(
                        WeatherDetail(
                            response.weatherStateName,
                            response.weatherStateAbbr,
                            response.theTemp,
                            response.humidity
                        )
                    )
                }
                weatherResult.add(Weather(it.title, weatherDetailList))
            }
            _weatherResultList.value = weatherResult
            _isLoading.value = false
        }
    }
}
