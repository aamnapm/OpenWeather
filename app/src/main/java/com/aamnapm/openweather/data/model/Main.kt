package com.aamnapm.openweather.data.model

import com.google.gson.annotations.SerializedName

data class Main(

    @SerializedName("temp")
    val lon: Float,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("temp_min")
    val tempMin: Float,

    @SerializedName("temp_max")
    val tempMax: Float

)