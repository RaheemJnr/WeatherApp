package com.evapingnow.weatherforcast.data.network.model

import com.evapingnow.weatherforcast.domain.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * a data transfer object that is used to map domain model data
 */
@JsonClass(generateAdapter = true)
data class WeatherDTO(
    @Json(name = "dt")
    val dateInUnix: Int? = null,
    @Json(name = "main")
    val main: Main? = null,
    @Json(name = "weather")
    val weather: List<Weather> = listOf(),
    @Json(name = "clouds")
    val clouds: Clouds? = null,
    @Json(name = "wind")
    val wind: Wind? = null,
    @Json(name = "visibility")
    val visibility: Int? = null,
    @Json(name = "pop")
    val pop: Double? = null,
    @Json(name = "rain")
    val rain: Rain? = null,
    @Json(name = "sys")
    val sys: Sys? = null,
    @Json(name = "dt_txt")
    val dateInText: String? = null
)

