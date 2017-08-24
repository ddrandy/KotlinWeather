package com.randy.kotlinweather.domain

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 4:09 PM
 * Description: TODO
 */
data class ForecastList(val city: String, val country: String,
                        private val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)