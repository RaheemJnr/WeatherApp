package com.evapingnow.weatherforcast.repository

import com.evapingnow.weatherforcast.data.WeatherDTOMapper
import com.evapingnow.weatherforcast.data.network.WeatherApiCall
import com.evapingnow.weatherforcast.domain.HarareWeatherData

/**
 * repo implementation to that map network data to domains'
 */
class WeatherRepoImpl(private val mapper: WeatherDTOMapper) : WeatherDataRepo {

    override suspend fun getHarareWeatherDataList(): List<HarareWeatherData> {
        return mapper.toDomainList(
            WeatherApiCall.WEATHER_LIST_SERVICE.getWeatherDataList().list
        )
    }

    override suspend fun getHarareWeatherDataDetails(): List<HarareWeatherData> {
        return mapper.toDomainList(
            WeatherApiCall.WEATHER_DETAIL_SERVICE.getWeatherDataDetails().list
        )
    }
}