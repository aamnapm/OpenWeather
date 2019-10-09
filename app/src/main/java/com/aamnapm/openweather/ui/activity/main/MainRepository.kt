package com.aamnapm.openweather.ui.activity.main

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.data.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse

interface MainRepository {
    fun callCurrentWeatherApi(token: String): LiveData<ApiResponse<CurrentWeather>>
}