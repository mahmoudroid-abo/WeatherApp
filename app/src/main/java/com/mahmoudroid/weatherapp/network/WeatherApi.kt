package com.mahmoudroid.weatherapp.network

import com.mahmoudroid.weatherapp.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("weather/Cairo")
    suspend fun getWeather(): Response<Weather>

}