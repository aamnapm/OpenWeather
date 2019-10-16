package com.aamnapm.openweather.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(

    @SerializedName("speed")
    val speed: Double,

    @SerializedName("deg")
    val deg: Double

)