package com.aamnapm.openweather.di

import com.aamnapm.openweather.ui.activity.main.MainViewModel
import com.aamnapm.openweather.ui.fragment.selectcity.SelectCityViewModel
import com.aamnapm.openweather.ui.fragment.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel() }

    viewModel { SelectCityViewModel(get()) }

    viewModel { WeatherViewModel(get()) }


}