package com.aamnapm.openweather.ui.fragment.weather

import android.util.Log
import androidx.lifecycle.LiveData
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse


class WeatherRepositoryImpl(
    val currentWeatherApi: CurrentWeatherApi,
    val sharedPreferencesManager: SharedPreferencesManager
) : WeatherRepository {


    override fun callCurrentWeatherApi(
        units: String,
        city: String,
        token: String
    ): LiveData<ApiResponse<CurrentWeather>> {

        val apiResponse = currentWeatherApi.currentWeather(city, units, token)

        apiResponse.observeForever { response ->
            when (response) {
                is ApiSuccessResponse -> {
                    sharedPreferencesManager.setCityName(response.body.name)
                }
            }
        }
        return apiResponse
    }
}
