package com.evapingnow.weatherforcast.navigation

/** sealed class to hold possible screen destination and screen title */

sealed class MainScreen(val route: String, val title: String) {
    object ForeCastList : MainScreen("forecastList", "Forecast")
    object DetailsList : MainScreen("detail", "Detail")

}