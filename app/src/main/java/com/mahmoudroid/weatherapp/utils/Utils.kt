package com.mahmoudroid.weatherapp.utils

import java.util.*

object Utils {

    const val BASE_URL = "https://goweather.herokuapp.com/"

    fun getCurrentDay(): Int {
        val value: Calendar = Calendar.getInstance()
        return value.get(Calendar.DAY_OF_WEEK)
    }

    fun convertDay(dayNumber: Int): String {
        when (dayNumber) {
            1 -> {
                return "Sunday"
            }
            2 -> {
                return "Monday"
            }
            3 -> {
                return "Tuesday"
            }
            4 -> {
                return "Wednesd"
            }
            5 -> {
                return "Thursday"
            }
            6 -> {
                return "Friday"
            }
            7 -> {
                return "Saturday"
            }
        }
        return true.toString()
    }
}