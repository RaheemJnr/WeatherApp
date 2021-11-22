package com.evapingnow.weatherforcast.data

import com.evapingnow.weatherforcast.domain.HarareWeatherData
import com.evapingnow.weatherforcast.data.network.model.WeatherDTO

/**
 * we use #DomainMapper interface to map our domain model to network DTO
 */

class WeatherDTOMapper : DomainMapper<WeatherDTO, HarareWeatherData> {
    override fun mapToDomainModel(model: WeatherDTO)
            : HarareWeatherData {
        return HarareWeatherData(
            dt = model.dateInUnix,
            main = model.main,
            weather = model.weather,
            clouds = model.clouds,
            wind = model.wind,
            visibility = model.visibility,
            pop = model.pop,
            rain = model.rain,
            sys = model.sys,
            dt_txt = model.dateInText
        )
    }

    override fun mapFromDomainModel(domainModel: HarareWeatherData)
            : WeatherDTO {
        return WeatherDTO(
            dateInUnix = domainModel.dt,
            main = domainModel.main,
            weather = domainModel.weather ?: listOf(),
            clouds = domainModel.clouds,
            wind = domainModel.wind,
            visibility = domainModel.visibility,
            pop = domainModel.pop,
            rain = domainModel.rain,
            sys = domainModel.sys,
            dateInText = domainModel.dt_txt
        )
    }

    fun toDomainList(initial: List<WeatherDTO>)
            : List<HarareWeatherData> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<HarareWeatherData>)
            : List<WeatherDTO> {
        return initial.map { mapFromDomainModel(it) }
    }

}