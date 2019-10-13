package com.aamnapm.openweather.di

import com.aamnapm.openweather.ui.activity.main.MainRepository
import com.aamnapm.openweather.ui.activity.main.MainRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<MainRepository> { MainRepositoryImpl(get(), get()) }

}