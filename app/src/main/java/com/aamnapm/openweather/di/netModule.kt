package com.aamnapm.openweather.di

import LiveDataCallAdapterFactory
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun netModule(baseUrl: String) = module {

    single {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { message ->
                //                Logger.d("NETWORK: $message")
            }).apply {
            level = HttpLoggingInterceptor.Level.NONE
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
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    single { get<Retrofit>().create(CurrentWeatherApi::class.java) }
}