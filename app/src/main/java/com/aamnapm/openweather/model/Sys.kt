package com.aamnapm.openweather.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(

    @SerializedName("type")
    val type: Int,

    @SerializedName("id")
    val id: Long,

    @SerializedName("message")
    val message: Double,

    @SerializedName("country")
    val country: String,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
    val sunset: Long

    )