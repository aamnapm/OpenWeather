package com.aamnapm.openweather.ui.activity.main

import android.util.Log
import androidx.lifecycle.LiveData
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse


class MainRepositoryImpl(val currentWeatherApi: CurrentWeatherApi,val sharedPreferencesManager: SharedPreferencesManager) : MainRepository {


    override fun callCurrentWeatherApi(token: String): LiveData<ApiResponse<CurrentWeather>> {

        val apiResponse = currentWeatherApi.currentWeather(token)

        apiResponse.observeForever { response ->
            when (response) {
                is ApiSuccessResponse -> {
                    sharedPreferencesManager.setCityName(response.body.name)
                    Log.e("MainRepositoryImpl", "response success " + response.body.name)
                }
            }
        }
        return apiResponse
    }
}
