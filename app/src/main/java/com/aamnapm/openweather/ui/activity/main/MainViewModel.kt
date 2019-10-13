package com.aamnapm.openweather.ui.activity.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse

class MainViewModel(
    val mainRepository: MainRepository,
    val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel() {


    fun callCurrentWeatherApi() {

        var response = mainRepository.callCurrentWeatherApi("0a73c3a66de1a0f4cc2597d2801582b4")

        response.observeForever { response ->
            when (response) {
                response as ApiSuccessResponse<CurrentWeather> -> {

                    Log.e(
                        "ViewModel",
                        "Response success name " + sharedPreferencesManager.getCityName()
                    )
                }
            }
        }
    }
}