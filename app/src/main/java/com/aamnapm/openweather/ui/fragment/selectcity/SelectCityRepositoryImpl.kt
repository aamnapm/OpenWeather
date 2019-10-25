package com.aamnapm.openweather.ui.fragment.selectcity

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.data.api.CheckCityApi
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse


class SelectCityRepositoryImpl(val checkCityApi: CheckCityApi) : SelectCityRepository {

    override fun callCurrentWeatherApi(
        city: String,
        token: String
    ): LiveData<ApiResponse<CurrentWeather>> {
        return checkCityApi.currentWeather(city, token)
    }
}
