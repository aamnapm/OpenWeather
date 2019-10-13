package com.aamnapm.openweather.data.local.sharedprefrence

import android.app.Application
import android.content.Context
import android.content.SharedPreferences


class SharedPreferencesManager(private val app: Application) {


    private val APP_SETTINGS = "WEATHER_APP_SETTINGS"
    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = app.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
    }

    private val TOKEN = "TOKEN"
    private val CITY_NAME = "CITY_NAME"


    /**
     * set token
     *
     * @param token Its String and value is user token
     */
    fun setToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN, token)
        editor.commit()
    }

    /**
     * get token
     *
     * @return Its String and value is user token
     */
    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN, null)
    }

    /**
     * set token
     *
     * @param token Its String and value is user token
     */
    fun setCityName(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(CITY_NAME, token)
        editor.commit()
    }

    /**
     * get token
     *
     * @return Its String and value is user token
     */
    fun getCityName(): String? {
        return sharedPreferences.getString(CITY_NAME, null)
    }


}