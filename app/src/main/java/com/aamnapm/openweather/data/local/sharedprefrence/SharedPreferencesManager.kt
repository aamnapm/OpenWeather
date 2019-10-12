package com.aamnapm.openweather.data.local.sharedprefrence

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.aamnapm.openweather.config.AppController


class SharedPreferencesManager(val app: Application) {


    val APP_SETTINGS = "WEATHER_APP_SETTINGS"
    var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = app.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
    }

    private val TOKEN = "TOKEN"


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


}