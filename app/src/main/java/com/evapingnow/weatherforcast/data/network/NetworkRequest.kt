package com.evapingnow.weatherforcast.data.network

import com.evapingnow.weatherforcast.data.network.model.WeatherListResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

const val API_KEY = "034da672af3e87a27b2bfb04a03baaa1"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Main entry point for network access.
 */
object WeatherApiCall {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    //
    val WEATHER_LIST_SERVICE: GetWeatherListService by lazy {
        retrofit.create(GetWeatherListService::class.java)
    }

    //
    val WEATHER_DETAIL_SERVICE: GetWeatherDetailsService by lazy {
        retrofit.create(GetWeatherDetailsService::class.java)
    }

}

/**
 * A retrofit service to fetch list of weather data for listScreen and a single weather data for details screen
 */
interface GetWeatherListService {
    @GET("forecast?q=harare&units=metric&cnt=16&appid=$API_KEY")
    suspend fun getWeatherDataList(): WeatherListResponse
}

//
interface GetWeatherDetailsService {
    @GET("forecast?q=harare&units=metric&cnt=1&appid=$API_KEY")
    suspend fun getWeatherDataDetails(): WeatherListResponse
}