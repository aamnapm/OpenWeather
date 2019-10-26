package com.aamnapm.openweather.koin

import android.app.Application
import com.aamnapm.openweather.di.appModule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.mockito.Mockito

class KoinTest :AutoCloseKoinTest(){

    @Test
    fun check() {
        startKoin {
            androidContext(Mockito.mock(Application::class.java))
            modules(appModule)
        }.checkModules()

    }
}