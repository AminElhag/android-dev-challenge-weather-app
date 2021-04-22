/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.models.WeatherType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentDayWeatherType = MutableStateFlow(WeatherType.RAINY)
    val currentDayWeatherType: StateFlow<WeatherType> = _currentDayWeatherType

    private val _refreshing = MutableStateFlow(false)
    val refreshing: StateFlow<Boolean> = _refreshing

    fun refresh() {
        _refreshing.value = true
        viewModelScope.launch {
            delay(2000)
            _refreshing.value = false
            _currentDayWeatherType.value = when (_currentDayWeatherType.value) {
                WeatherType.SUNNY -> WeatherType.RAINY
                WeatherType.RAINY -> WeatherType.CLOUDY
                WeatherType.CLOUDY -> WeatherType.STORMY
                WeatherType.STORMY -> WeatherType.SUNNY
            }
        }
    }
}
