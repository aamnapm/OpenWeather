package com.aamnapm.openweather.ui.activity.main

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse


class MainRepositoryImpl : MainRepository {
    override fun callCurrentWeatherApi(token: String): LiveData<ApiResponse<CurrentWeather>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
