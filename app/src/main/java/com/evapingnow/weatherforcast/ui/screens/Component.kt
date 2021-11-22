package com.evapingnow.weatherforcast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evapingnow.weatherforcast.R
import com.evapingnow.weatherforcast.domain.HarareWeatherData

/**
 * Header text
 */
@Composable
fun HeaderText() {
    val annotatedString = remember {
        AnnotatedString.Builder("Harare, Zimbabwe")
            .apply {
                addStyle(
                    style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    0,
                    7
                )
                addStyle(style = SpanStyle(color = Color.Black), 8, 16)

            }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //location text
        Text(
            text = annotatedString.toAnnotatedString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .clickable(onClick = {}),
            textAlign = TextAlign.Center
        )
        Image(
            Icons.Filled.ArrowDropDown, contentDescription = "",
            modifier = Modifier.size(8.dp)

        )
    }
}

/**
 * list item container
 */
@ExperimentalMaterialApi
@Composable
fun WeatherListItemCard(
    weather: HarareWeatherData,
    onClick: () -> Unit,
    days: Int
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = onClick,
        backgroundColor = Color.Black,
        elevation = 8.dp
    ) {
        Column(modifier = Modifier) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //day text
                Text(
                    text = "DAY $days",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif
                )
                //temp row
                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "${weather.main?.temp}\u2103",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Image(
                        Icons.Default.Thermostat, contentDescription = "",
                        modifier = Modifier.padding(
                            start = 0.dp,
                            top = 8.dp,
                            end = 4.dp,
                            8.dp
                        ),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
            //date row
            Row(
                modifier = Modifier
                    .padding(start = 3.dp),
            ) {
                weather.dt_txt?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 2.dp),
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        overflow = TextOverflow.Clip
                    )
                }

            }
        }
    }
}



