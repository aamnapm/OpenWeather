package com.aamnapm.openweather.ui.fragment.weather

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse

interface WeatherRepository {
    fun callCurrentWeatherApi(
        units: String,
        city: String,
        token: String
    ): LiveData<ApiResponse<CurrentWeather>>
}