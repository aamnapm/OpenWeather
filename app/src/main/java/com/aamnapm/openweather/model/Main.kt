package com.aamnapm.openweather.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Main(

    @SerializedName("temp")
    val temp: Float,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("temp_min")
    val tempMin: Float,

    @SerializedName("temp_max")
    val tempMax: Float

)