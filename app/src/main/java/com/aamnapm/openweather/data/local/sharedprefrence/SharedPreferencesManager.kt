package com.aamnapm.openweather.data.local.sharedprefrence

import android.content.Context
import android.content.SharedPreferences
import com.aamnapm.openweather.config.AppController


class SharedPreferencesManager(val appController: AppController) {


    private val APP_SETTINGS = "BDOODKAR_APP_SETTINGS"
    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = appController.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
    }

    private val ROLE = "ROLE"
    private val UUID = "UUID"
    private val TOKEN = "TOKEN"
    private val EXPIRE_IN = "EXPIRE_IN"
    private val USER_NAME = "USER_NAME"
    private val USER_IMAGE = "USER_IMAGE"
    private val HELPER_UUID = "HELPER_UUID "
    private val REFRESH_TOKEN = "REFRESH_TOKEN"
    private val USER_NAME_HELPER = "USER_NAME_HELPER"


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