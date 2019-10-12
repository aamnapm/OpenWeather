package com.aamnapm.openweather.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_weather")
data class WeatherEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "weather_id") val id: Int = 0,
    @ColumnInfo(name = "city") var age: Int

)