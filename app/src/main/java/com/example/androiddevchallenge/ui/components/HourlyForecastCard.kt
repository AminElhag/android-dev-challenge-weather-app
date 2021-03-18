package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.constants.StringConstants.DEGREE

data class HourlyForecastData(
    val time: Int,
    val am: Boolean,
    val temperature: Int
)

val sampleData = listOf(
    HourlyForecastData(
        -1,
        true,
        87
    ),
    HourlyForecastData(
        10,
        true,
        89
    ),
    HourlyForecastData(
        11,
        true,
        87
    ),
    HourlyForecastData(
        12,
        false,
        91
    ),
    HourlyForecastData(
        1,
        false,
        93
    ),
    HourlyForecastData(
        2,
        false,
        93
    ),
    HourlyForecastData(
        3,
        false,
        91
    ),
    HourlyForecastData(
        4,
        false,
        89
    ),
    HourlyForecastData(
        5,
        false,
        87
    ),
    HourlyForecastData(
        6,
        false,
        86
    ),
)

@Composable
fun HourlyForecastCard(modifier: Modifier) {
    Surface(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Column(Modifier.padding(15.dp)) {
            Text(text = "Hourly Forecast")
            Spacer(Modifier.size(20.dp))
            Row(
                Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                sampleData.forEach {
                    HourlyForecastItem(it)
                }
            }
        }
    }
}

@Composable
fun HourlyForecastItem(data: HourlyForecastData) {
    val (time, am, temperature) = data
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = if (time != -1) "$time${if (am) "AM" else "PM"}" else "Now")
        Icon(painter = painterResource(R.drawable.ic_sunny), contentDescription = "Weather Type")
        Text(text = "$temperature$DEGREE")
    }
}