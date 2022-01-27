package com.mahmoudroid.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mahmoudroid.weatherapp.databinding.ActivityMainBinding
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
                tvCityName.text = getString(R.string.location_text)
                tvTemperature.text = weather.temperature
                tvDescription.text = weather.description
                tvWind.text = weather.wind


                val dayOneForecast = weather.forecast[0]
                val dayTwoForecast = weather.forecast[1]
                val dayThreeForecast = weather.forecast[2]

                tvForecast1.text = "${dayOneForecast.temperature} / ${dayOneForecast.wind}"
                tvForecast2.text = "${dayTwoForecast.temperature} / ${dayTwoForecast.wind}"
                tvForecast3.text = "${dayThreeForecast.temperature} / ${dayThreeForecast.wind}"
            }
        })
    }
}