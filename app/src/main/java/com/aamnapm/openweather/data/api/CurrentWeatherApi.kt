package com.aamnapm.openweather.data.api

import androidx.lifecycle.LiveData
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherApi {

    @GET("/data/2.5/weather")
    fun currentWeather(
        @Query("q") city: String,
        @Query("units") units: String
        , @Query("appid") token: String
    ): LiveData<ApiResponse<CurrentWeather>>
}