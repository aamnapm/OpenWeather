package com.aamnapm.openweather.di

import com.aamnapm.openweather.ui.activity.main.MainRepository
import com.aamnapm.openweather.ui.activity.main.MainRepositoryImpl
import com.aamnapm.openweather.ui.fragment.selectcity.SelectCityRepository
import com.aamnapm.openweather.ui.fragment.selectcity.SelectCityRepositoryImpl
import com.aamnapm.openweather.ui.fragment.weather.WeatherRepository
import com.aamnapm.openweather.ui.fragment.weather.WeatherRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<MainRepository> { MainRepositoryImpl() }

    factory<SelectCityRepository> { SelectCityRepositoryImpl() }

    factory<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }


}