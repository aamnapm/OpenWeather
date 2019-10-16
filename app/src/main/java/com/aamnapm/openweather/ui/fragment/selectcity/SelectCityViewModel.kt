package com.aamnapm.openweather.ui.fragment.selectcity

import androidx.lifecycle.ViewModel


class SelectCityViewModel() : ViewModel() {

//    private val _cityName = MutableLiveData<String>()
//    val cityName: MutableLiveData<String>
//        get() = _cityName

    var cityName: String = ""

    /**
     * set value from editText to cityName
     */
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//        _cityName.value = s.toString()
        cityName = s.toString()
    }
}