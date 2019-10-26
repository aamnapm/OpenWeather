package com.aamnapm.openweather.viewmodel

import androidx.lifecycle.MutableLiveData
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.di.appModule
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.ui.fragment.weather.WeatherRepository
import com.aamnapm.openweather.ui.fragment.weather.WeatherViewModel
import com.aamnapm.openweather.utils.api.apikotlin.ApiResponse
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get
import org.koin.test.mock.declareMock
import org.mockito.Mockito

class WeatherViewModelTest : AutoCloseKoinTest() {


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
    fun teMainViewModel() {

        val repositoryMockResponseData =
            Mockito.mock(MutableLiveData<ApiResponse<CurrentWeather>>()::class.java)

        val onLoadingMockData =
            Mockito.mock(MutableLiveData<Boolean>()::class.java)

        //get MainRepository mock and set it on api variable
        var repo = get<WeatherRepository>()

        //create object of MainViewModel
        val weatherViewModel = WeatherViewModel(repo)

        //when repo.callSearchBookApi("") called return mock data
        Mockito.`when`(
            repo.callCurrentWeatherApi(
                "metric",
                "Tehran",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ).thenReturn(repositoryMockResponseData)

//        Mockito.`when`( weatherViewModel.callCurrentWeatherApi(
//            "metric",
//            "Tehran"
//        )).thenReturn(onLoadingMockData)

        //call MainViewModel method
        weatherViewModel.callCurrentWeatherApi(
            "metric",
            "Tehran"
        )

        //this line check
        //when call MainViewModel method
        //callSearchBookApi() method called or no
        Mockito.verify(repo).callCurrentWeatherApi(
            "metric",
            "Tehran",
            "0a73c3a66de1a0f4cc2597d2801582b4"
        )
    }
}