package com.mahmoudroid.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mahmoudroid.weatherapp.databinding.ActivityMainBinding
import com.mahmoudroid.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

private const val TAG = "####"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.weatherResp.observe(this, Observer { weather ->
            binding.apply {
                textCityName.text = getString(R.string.location_text)
                textTemperature.text = weather.temperature
                textDescription.text = weather.description
                textWind.text = weather.wind
                textToday.text = convertDay(getCurrentDay())

//                when (getCurrentDay()) {
//                    1 -> {
//                        textToday.text = "Sunday"
//                    }
//                    2 -> {
//                        textToday.text = "Monday"
//                    }
//                    3 -> {
//                        textToday.text = "Tuesday"
//                    }
//                    4 -> {
//                        textToday.text = "Wednesday"
//                    }
//                    5 -> {
//                        textToday.text = "Thursday"
//                    }
//                    6 -> {
//                        textToday.text = "Friday"
//                    }
//                    7 -> {
//                        textToday.text = "Saturday"
//                    }
//                }

                val dayOneForecast = weather.forecast[0]
                val dayTwoForecast = weather.forecast[1]
                val dayThreeForecast = weather.forecast[2]

                var calculateDayOneForecast: Int = getCurrentDay() + 1
                var calculateDayTwoForecast: Int = getCurrentDay() + 2
                var calculateDayThreeForecast: Int = getCurrentDay() + 3

                textDayOneForecast.text = convertDay(calculateDayOneForecast)
                textDayTwoForecast.text = convertDay(calculateDayTwoForecast)
                textDayThreeForecast.text = convertDay(calculateDayThreeForecast)

                tvForecast1.text = "${dayOneForecast.temperature} " +
                        "/ ${dayOneForecast.wind}"
                tvForecast2.text = "${dayTwoForecast.temperature} " +
                        "/ ${dayTwoForecast.wind}"
                tvForecast3.text = "${dayThreeForecast.temperature} " +
                        "/ ${dayThreeForecast.wind}"
            }
        })
    }


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
                return "Wednesday"
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