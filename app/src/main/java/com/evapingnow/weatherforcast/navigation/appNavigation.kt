package com.evapingnow.weatherforcast.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.evapingnow.weatherforcast.ui.screens.WeatherDetailScreen
import com.evapingnow.weatherforcast.ui.screens.WeatherListScreen


/** nav graph to navigate to respective screens */
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = MainScreen.ForeCastList.route) {
        //weatherList
        composable(MainScreen.ForeCastList.route) {
            WeatherListScreen(navController)
        }
        //
        composable(MainScreen.DetailsList.route) {
            WeatherDetailScreen()
        }

    }


}
