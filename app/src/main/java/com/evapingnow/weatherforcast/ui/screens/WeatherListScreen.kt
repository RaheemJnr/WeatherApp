package com.evapingnow.weatherforcast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.evapingnow.weatherforcast.data.WeatherDTOMapper
import com.evapingnow.weatherforcast.navigation.MainScreen
import com.evapingnow.weatherforcast.repository.WeatherRepoImpl
import com.evapingnow.weatherforcast.utils.LoaderDialog
import com.evapingnow.weatherforcast.viewModel.AuthViewModelFactory
import com.evapingnow.weatherforcast.viewModel.WeatherViewModel

/**
 * screen to show weather screen
 */
@ExperimentalMaterialApi
@Composable
fun WeatherListScreen(navController: NavHostController) {
    // reference to viewModel
    val weatherViewModel: WeatherViewModel = viewModel(
        factory = AuthViewModelFactory(WeatherRepoImpl(WeatherDTOMapper()))
    )
    //
    val weather = weatherViewModel.weatherDataList.value
    //
    val loading = weatherViewModel.listLoading.value
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        //list header
        HeaderText()
        Spacer(modifier = Modifier.height(22.dp))
        //listBody
        if (loading && weather.isEmpty()) {
            LoaderDialog()
        } else {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black)
                    .padding(horizontal = 12.dp)
            ) {
                Spacer(modifier = Modifier.height(22.dp))
                //
                LazyColumn(
                    modifier = Modifier
                        .wrapContentHeight()
                ) {
                    itemsIndexed(
                        items = weather
                    ) { index, item ->
                        WeatherListItemCard(
                            weather = item,
                            onClick = { navController.navigate(MainScreen.DetailsList.route) },
                            index + 1
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(52.dp))
    }
    Spacer(modifier = Modifier.height(52.dp))
}


//preview
@Preview(showBackground = true)
@Composable
fun WeatherListPrev() {
}