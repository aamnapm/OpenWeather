package com.aamnapm.openweather.ui.fragment.selectcity

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse

interface SelectCityRepository {
    fun callCurrentWeatherApi(token: String): LiveData<ApiResponse<CurrentWeather>>
}