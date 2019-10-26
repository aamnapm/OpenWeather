package com.aamnapm.openweather.repository

import androidx.lifecycle.MutableLiveData
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.di.appModule
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.ui.fragment.weather.WeatherRepository
import com.aamnapm.openweather.ui.fragment.weather.WeatherRepositoryImpl
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get
import org.koin.test.mock.declareMock
import org.mockito.Mockito

class WeatherRepositoryTest : AutoCloseKoinTest() {


    @Before
    fun createService() {

        startKoin {
            modules(appModule)
        }

        declareMock<CurrentWeatherApi>()
        declareMock<SharedPreferencesManager>()
        declareMock<WeatherRepository>()
    }

    @Test
    fun testWeatherRepositoryImpl() {
        //create mock data
        val apiMockResponseData =
            Mockito.mock(MutableLiveData<ApiResponse<CurrentWeather>>()::class.java)

        //get searchApi mock and set it on api variable
        var currentWeatherApi = get<CurrentWeatherApi>()
        var sharedPreferencesManager = get<SharedPreferencesManager>()

        //create object of MainRepositoryImpl
        val weatherRepositoryImpl =
            WeatherRepositoryImpl(currentWeatherApi, sharedPreferencesManager)

        //when searchBookApi.searchBook("") called return mock data
        Mockito.`when`(
            currentWeatherApi.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ).thenReturn(apiMockResponseData)

        //call mainRepositoryImpl method
        weatherRepositoryImpl.currentWeatherApi.currentWeather(
            "Tehran",
            "metric",
            "0a73c3a66de1a0f4cc2597d2801582b4"
        )

        //this line check
        //when call mainRepositoryImpl method
        //searchBook() method called or no
        Mockito.verify(currentWeatherApi).currentWeather(
            "Tehran",
            "metric",
            "0a73c3a66de1a0f4cc2597d2801582b4"
        )
    }

}