package com.aamnapm.openweather.ui.activity.main

import android.util.Log
import androidx.lifecycle.LiveData
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse


class MainRepositoryImpl(val currentWeatherApi: CurrentWeatherApi) : MainRepository {

    override fun callCurrentWeatherApi(token: String): LiveData<ApiResponse<CurrentWeather>> {

        var response = currentWeatherApi.currentWeather(token)

        response.observeForever { response ->

            when (response) {
                response as ApiSuccessResponse<CurrentWeather> -> {
                    Log.e("MainRepositoryImpl", "response success " + response.body.coord)
                }
            }
        }

        return response
    }
}
