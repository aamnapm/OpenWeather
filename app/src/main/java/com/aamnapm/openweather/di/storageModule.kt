package com.aamnapm.openweather.di

import com.aamnapm.openweather.data.local.sharedprefrence.SharedPreferencesManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val storageModule = module {

    single { SharedPreferencesManager(androidApplication()) }

}