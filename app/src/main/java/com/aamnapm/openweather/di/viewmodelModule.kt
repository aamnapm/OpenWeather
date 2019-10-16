package com.aamnapm.openweather.di

import com.aamnapm.openweather.ui.activity.main.MainViewModel
import com.aamnapm.openweather.ui.fragment.selectcity.SelectCityViewModel
import com.aamnapm.openweather.ui.fragment.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    var v = viewModel(named("Main")) { MainViewModel() }

    var vv = viewModel(named("SelectCity")) { SelectCityViewModel() }

    var vvv = viewModel(named(" Weather")) { WeatherViewModel(get()) }


}