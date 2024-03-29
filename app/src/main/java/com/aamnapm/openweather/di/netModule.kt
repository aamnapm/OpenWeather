package com.aamnapm.openweather.di


import com.aamnapm.openweather.data.api.CheckCityApi
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.utils.api.apikotlin.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netModule = module {

    single {

        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("http://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    single { get<Retrofit>().create(CurrentWeatherApi::class.java) }
    single { get<Retrofit>().create(CheckCityApi::class.java) }
}