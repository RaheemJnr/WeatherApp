package com.evapingnow.weatherforcast.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.evapingnow.weatherforcast.data.WeatherDTOMapper
import com.evapingnow.weatherforcast.data.network.model.WeatherDTO
import com.evapingnow.weatherforcast.domain.HarareWeatherData
import com.evapingnow.weatherforcast.repository.WeatherDataRepo
import kotlinx.coroutines.launch

/**
 * i used the same viewModel for both the list and detail screen because the code is straight forward and not too much
 */
class WeatherViewModel(private val repo: WeatherDataRepo) : ViewModel() {
    // for list
    val weatherDataList: MutableState<List<HarareWeatherData>> = mutableStateOf(listOf())

    //for details
    val weatherDataDetails: MutableState<List<HarareWeatherData?>> = mutableStateOf(listOf())

    //
    val listLoading: MutableState<Boolean> = mutableStateOf(false)

    //
    val loadingDetails: MutableState<Boolean> = mutableStateOf(false)


    init {
        //launch a coroutine scope, show loading value,fetch data and render the data
        viewModelScope.launch {
            listLoading.value = true
            val result = repo.getHarareWeatherDataList()
            weatherDataList.value = result
            listLoading.value = false
        }
    //launch a coroutine scope, show loading value,fetch data and render the data
        viewModelScope.launch {
            loadingDetails.value = true
            val result = repo.getHarareWeatherDataDetails()
            weatherDataDetails.value = result
            loadingDetails.value = false

        }
    }
}


/** viewModel Factory
 * it function is to tell the viewmodel how to create the repo object injected as a dependency
 * */
class AuthViewModelFactory(private val repo: WeatherDataRepo) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(repo) as T
    }
}