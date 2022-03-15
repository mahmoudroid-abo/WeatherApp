package com.mahmoudroid.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mahmoudroid.weatherapp.databinding.ActivityMainBinding
import com.mahmoudroid.weatherapp.utils.Utils.convertDay
import com.mahmoudroid.weatherapp.utils.Utils.getCurrentDay
import com.mahmoudroid.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

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
                val dayOneForecast = weather.forecast[0]
                val dayTwoForecast = weather.forecast[1]
                val dayThreeForecast = weather.forecast[2]

                var calculateDayOneForecast: Int = getCurrentDay() + 1
                var calculateDayTwoForecast: Int = getCurrentDay() + 2
                var calculateDayThreeForecast: Int = getCurrentDay() + 3

                textDayOneForecast.text = convertDay(calculateDayOneForecast)
                textDayTwoForecast.text = convertDay(calculateDayTwoForecast)
                textDayThreeForecast.text = convertDay(calculateDayThreeForecast)

                tvForecast1.text = "${dayOneForecast.temperature}\n " +
                        "\n ${dayOneForecast.wind}"
                tvForecast2.text = "${"+" + dayTwoForecast.temperature}\n " +
                        "\n ${dayTwoForecast.wind}"
                tvForecast3.text = "${dayThreeForecast.temperature}\n " +
                        "\n ${dayThreeForecast.wind}"
            }
        })
    }
}