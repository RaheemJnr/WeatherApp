package com.evapingnow.weatherforcast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.evapingnow.weatherforcast.R
import com.evapingnow.weatherforcast.data.WeatherDTOMapper
import com.evapingnow.weatherforcast.domain.HarareWeatherData
import com.evapingnow.weatherforcast.repository.WeatherRepoImpl
import com.evapingnow.weatherforcast.utils.LoaderDialog
import com.evapingnow.weatherforcast.utils.formatTemp
import com.evapingnow.weatherforcast.utils.getTemp
import com.evapingnow.weatherforcast.utils.hourOfDay
import com.evapingnow.weatherforcast.viewModel.AuthViewModelFactory
import com.evapingnow.weatherforcast.viewModel.WeatherViewModel

/**
 * datails screen to show a single weather data
 */

@Composable
fun WeatherDetailScreen() {
    //
    val weatherViewModel: WeatherViewModel = viewModel(
        factory = AuthViewModelFactory(WeatherRepoImpl(WeatherDTOMapper()))
    )
    val weatherDetails = weatherViewModel.weatherDataDetails.value
//
    val loading = weatherViewModel.loadingDetails.value

    if (loading) {
        LoaderDialog()
    } else {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xfff2f2f6))
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            HeaderText()
            Spacer(modifier = Modifier.height(50.dp))
            LazyColumn(
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                itemsIndexed(
                    items = weatherDetails
                ) { _, item ->
                    if (item != null) {
                        CardOne(item)
                    }
                    Spacer(modifier = Modifier.height(22.dp))
                    if (item != null) {
                        CardTwo(item)
                    }
                    Spacer(modifier = Modifier.height(22.dp))
                    if (item != null) {
                        CardThree(item)
                    }
                }
            }
        }
    }


}

//card one
@Composable
fun CardOne(weather: HarareWeatherData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .size(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        //parent box
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.weather_background),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )
            //icon box
            Box(
                modifier = Modifier.fillMaxHeight(0.5f)
            ) {
                Icon(
                    Icons.Filled.NightsStay, contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .wrapContentSize()
                        .size(100.dp)
                        .padding(horizontal = 16.dp)
                )
            }
            //text box
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxHeight(0.7f)
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                ) {
                    for (i in weather.weather!!) {
                        Text(
                            text = "${i.description}",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                    Text(
                        text = "Good ${hourOfDay()}",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )

                }
            }
            //temp box
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                ) {
                    //formatTemp("${weather.main?.temp}")
                    Text(
                        text = "${formatTemp("${weather.main?.temp}")}°",
                        fontSize = 83.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        overflow = TextOverflow.Clip
                    )
                    Text(
                        text = "Feels like ${formatTemp("${weather.main?.feels_like}")}°",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = getTemp(weather.main?.temp),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )

                }
            }
        }
    }
}

// card two
@Composable
fun CardTwo(weather: HarareWeatherData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Wind",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.wind?.speed}m/h",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Humidity",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.main?.humidity}/h",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Visibility",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.visibility}%",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

    }
}

// card three
@Composable
fun CardThree(weather: HarareWeatherData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Pressure",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.main?.pressure}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Sea Level",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.main?.sea_level}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
            //
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Ground Level",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${weather.main?.grnd_level}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

    }
}

//preview
@Preview(showBackground = true)
@Composable
fun DetailScreen() {
    WeatherDetailScreen()
}

