package com.aamnapm.openweather.ui.fragment.selectcity

import android.widget.RadioGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.ApiNotFoundErrorResponse
import com.aamnapm.openweather.utils.api.apikotlin.ApiSuccessResponse


class SelectCityViewModel(val selectCityRepository: SelectCityRepository) : ViewModel() {

    var temperature: String = ""
        get() = field
        set(value) {
            field = value
        }


    private val _cityName = MutableLiveData<String>()
    val cityName: MutableLiveData<String>
        get() = _cityName

    private val _isCityAvailable = MutableLiveData<Boolean>()
    val isCityAvailable: MutableLiveData<Boolean>
        get() = _isCityAvailable


    /**
     * set value from editText to cityName
     */
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        cityName.value = s.toString()

        if (!s.equals(" ")) {
            var response = selectCityRepository.callCurrentWeatherApi(
                cityName.value.toString(),
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )

            response.observeForever {
                when (it) {
                    is ApiSuccessResponse<CurrentWeather> -> {
                        _isCityAvailable.value = true
                    }
                    is ApiNotFoundErrorResponse -> {
                        _isCityAvailable.value = false
                    }
                }
            }
        }
    }


    /**
     * set temperature unit
     *
     * ""       means Kelvin
     * metric   means Celsius
     * imperial means Fahrenheit
     */
    fun onSplitTypeChanged(radioGroup: RadioGroup, id: Int) {
        when (id) {
            2131230897 -> temperature = ""

            2131230895 -> temperature = "metric"

            2131230896 -> temperature = "imperial"
        }
    }
}