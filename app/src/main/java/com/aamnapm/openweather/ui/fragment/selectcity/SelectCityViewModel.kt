package com.aamnapm.openweather.ui.fragment.selectcity

import androidx.lifecycle.ViewModel


class SelectCityViewModel() : ViewModel() {

    var kelvin: Boolean = false
        set(value) {
            field = value
        }
    var celsius: Boolean = true
        set(value) {
            field = value
        }

    var fahrenheit: Boolean = false
        set(value) {
            field = value
        }
    var cityName: String = ""

    /**
     * set value from editText to cityName
     */
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        cityName = s.toString()
    }
}