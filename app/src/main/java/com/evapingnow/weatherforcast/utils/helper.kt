package com.evapingnow.weatherforcast.utils

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.time.Instant
import java.util.*

/**
 * an helper class that provide formatting to data
 */


//loading dialog
@Composable
fun LoaderDialog() {
    Dialog(
        onDismissRequest = {},
        DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        }
    }
}

//format time
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
fun convertIntToDateString(systemTime: Int): String {
    return Date.from(Instant.ofEpochSecond(systemTime.toLong())).toString()
}

//get hour of day and map to time of the day
fun hourOfDay(): String {
    val calender = Calendar.getInstance()
    val timeOfDay: String = when (calender.get(Calendar.HOUR_OF_DAY)) {
        in 0..5 -> "Early morning"
        in 6..11 -> "Morning"
        in 12..16 -> "Afternoon"
        in 17..19 -> "Evening"
        in 20..23 -> "Late evening"
        else -> "INVALID HOUR!"
    }
    return timeOfDay
}

// substring to format temp to match UI
fun formatTemp(t: String): CharSequence {
    return t.subSequence(0, 2)
}

//
fun getTemp(t: Double?): String {
    val temp: String = when {
        t!! > 25 -> "Hot Day"
        t < 10 -> "Cold Day"
        else -> {
            "Average Temp Day"
        }
    }
    return temp

}
