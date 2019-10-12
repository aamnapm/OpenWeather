package com.aamnapm.openweather.model

import com.google.gson.annotations.SerializedName

data class Clouds(

    @SerializedName("clouds")
    val clouds: Int
)