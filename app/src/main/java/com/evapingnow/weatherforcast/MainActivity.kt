package com.evapingnow.weatherforcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.evapingnow.weatherforcast.navigation.MainScreenNavigation
import com.evapingnow.weatherforcast.ui.screens.WeatherListScreen
import com.evapingnow.weatherforcast.ui.theme.WeatherForcastTheme

/**
 * a single activity that house the composable screens
 */

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WeatherForcastTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreenNavigation()
                }
            }
        }
    }
}

//preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherForcastTheme {

    }
}