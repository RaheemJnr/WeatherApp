package com.evapingnow.weatherforcast.data.network.model

import com.squareup.moshi.Json


/**
 * a data class that is returned by the network
 */
data class WeatherListResponse(
    @Json(name = "cnt")
    var count: Int,
    @Json(name = "list")
    var list: List<WeatherDTO>

)

