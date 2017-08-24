package com.randy.kotlinweather.domain

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 4:09 PM
 * Description: TODO
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)