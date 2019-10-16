package com.aamnapm.openweather.ui.fragment.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiErrorResponse
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse


class WeatherViewModel(val weatherRepository: WeatherRepository) : ViewModel() {


    /**
     * api boolean
     */
    var onLoading = MutableLiveData<Boolean>()

    /**
     * api error response
     */
    var errorResponse = MutableLiveData<Int>()

    /**
     * api success response
     */
    var successResponse = MutableLiveData<CurrentWeather>()


    private val _cityName = MutableLiveData<String>()
    val cityName: MutableLiveData<String>
        get() = _cityName

    private val _cityTemperature = MutableLiveData<String>()
    val cityTemperature: MutableLiveData<String>
        get() = _cityTemperature

    private val _cityWeather = MutableLiveData<String>()
    val cityWeather: MutableLiveData<String>
        get() = _cityWeather

    private val _cityDate = MutableLiveData<String>()
    val cityDate: MutableLiveData<String>
        get() = _cityDate


    /**
     * call api and  wait for response
     */
    fun callCurrentWeatherApi(units: String, city: String) {

        //update ui
        onLoading.value = true

        var response =
            weatherRepository.callCurrentWeatherApi(units, city, "0a73c3a66de1a0f4cc2597d2801582b4")

        response.observeForever {

            //update ui
            onLoading.value = false
            when (it) {
                is ApiSuccessResponse<CurrentWeather> -> {

                    //set data on view
                    _cityName.value = it.body.name
                    _cityDate.value = "tempMax: ${it.body.main.tempMax}"
                    _cityWeather.value = "tempMin: ${it.body.main.tempMin}"
                    _cityTemperature.value = "pressure : ${it.body.main.pressure}"


                    successResponse.value = it.body

                }
                is ApiErrorResponse -> {
                    errorResponse.value = it.errorCode
                }
            }
        }
    }


}