package com.aamnapm.openweather.config

import android.app.Application
import com.aamnapm.openweather.di.appModule
import com.aamnapm.openweather.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(netModule("http://api.openweathermap.org") + appModule)
        }
    }
}