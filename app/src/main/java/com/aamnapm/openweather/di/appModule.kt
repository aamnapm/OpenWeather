package com.aamnapm.openweather.di

import com.aamnapm.openweather.config.AppController
import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import com.aamnapm.openweather.ui.activity.main.MainRepository
import com.aamnapm.openweather.ui.activity.main.MainRepositoryImpl
import com.aamnapm.openweather.ui.activity.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * init module
 */
val appModule = module {

    single { SharedPreferencesManager(get()) }

    single { AppController() }

    factory<MainRepository> { MainRepositoryImpl(get()) }

    viewModel { MainViewModel(get(),get()) }

//    factory<SplashRepository> { SplashRepositoryImpl(get) }
//    viewModel { SplashViewModel(get()) }

}
