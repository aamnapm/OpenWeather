package com.aamnapm.openweather.data.model

import com.google.gson.annotations.SerializedName

data class Clouds(

    @SerializedName("clouds")
    val clouds: Int
)