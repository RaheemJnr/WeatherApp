package com.evapingnow.weatherforcast.repository


import com.evapingnow.weatherforcast.domain.HarareWeatherData

/**
 * interface to get our data
 */
interface WeatherDataRepo {
    suspend fun getHarareWeatherDataList(): List<HarareWeatherData>

    suspend fun getHarareWeatherDataDetails(): List<HarareWeatherData>
}