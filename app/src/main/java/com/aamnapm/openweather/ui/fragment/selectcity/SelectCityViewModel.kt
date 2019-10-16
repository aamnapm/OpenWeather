package com.aamnapm.openweather.ui.fragment.selectcity

import androidx.lifecycle.ViewModel


class SelectCityViewModel() : ViewModel() {

    var cityName: String = ""

    /**
     * set value from editText to cityName
     */
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        cityName = s.toString()
    }
}