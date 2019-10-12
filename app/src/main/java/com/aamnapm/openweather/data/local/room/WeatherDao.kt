package com.aamnapm.openweather.data.local.room

import androidx.room.*
import com.aamnapm.openweather.model.WeatherEntity


@Dao
interface WeatherDao {
    @Query("SELECT * FROM city_weather")
    fun getAllStudent(): List<WeatherEntity>

    @Query("SELECT * FROM city_weather WHERE city LIKE :city")
    fun findByAge(city: String): WeatherEntity

    @Insert
    fun insertAll(vararg student: WeatherEntity)

    @Delete
    fun delete(student: WeatherEntity)

    @Update
    fun updateTodo(vararg students: WeatherEntity)
}