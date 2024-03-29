package com.aamnapm.openweather.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable



data class CurrentWeather(

    @SerializedName("coord")
    val coord: Coord,

    @SerializedName("weather")
    val weather: List<Weather>,

    @SerializedName("base")
    val base: String,

    @SerializedName("main")
    val main: Main,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("sys")
    val sys: Sys,

    @SerializedName("timezone")
    val timezone: Long,

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("cod")
    val cod: Int
)