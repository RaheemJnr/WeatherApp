package com.evapingnow.weatherforcast.domain


/**
 * domain model that model response from server and what to display in the UI
 */
data class HarareWeatherData(
    val dt: Int? = null,
    val main: Main? = null,
    val weather: List<Weather>? = null,
    val clouds: Clouds? = null,
    val wind: Wind? = null,
    val visibility: Int? = null,
    val pop: Double? = null,
    val rain: Rain? = null,
    val sys: Sys? = null,
    val dt_txt: String? = null
)

data class Weather(
    val id: Int? = null,
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null
)


data class City(
    val id: Int,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)


data class Clouds(
    val all: Int? = null
)

data class Coord(
    val lat: Double? = null,
    val lon: Double? = null
)

data class Main(
    val temp: Double? = null,
    val feels_like: Double? = null,
    val temp_min: Double? = null,
    val temp_max: Double? = null,
    val pressure: Int? = null,
    val sea_level: Int? = null,
    val grnd_level: Int? = null,
    val humidity: Int? = null,
    val temp_kf: Double? = null
)


data class Rain(
    val ThreeHour: Double? = null
)


data class Sys(
    val pod: String? = null
)


data class Wind(

    val speed: Double? = null,
    val deg: Int? = null,
    val gust: Double? = null
)