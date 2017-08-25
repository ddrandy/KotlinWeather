package com.randy.kotlinweather.database

import com.randy.kotlinweather.database.model.CityForecast
import com.randy.kotlinweather.database.model.DayForecast
import com.randy.kotlinweather.domain.Forecast

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 5:10 PM
 * Description: TODO
 */
class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertToDomain(it) }
//        TODO("not implement")
//        ForecastList(_id, city, country, daily)
    }

    private fun convertToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date.toString(), description, high, low, iconUrl)
    }
}