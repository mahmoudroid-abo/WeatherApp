package com.mahmoudroid.weatherapp.repository

import com.mahmoudroid.weatherapp.network.WeatherApi
import javax.inject.Inject


class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getWeather() = api.getWeather()
}