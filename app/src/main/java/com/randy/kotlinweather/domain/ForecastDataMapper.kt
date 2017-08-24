package com.randy.kotlinweather.domain

import com.randy.kotlinweather.data.Forecast
import com.randy.kotlinweather.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.randy.kotlinweather.domain.Forecast as ModelForecast

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 4:11 PM
 * Description: TODO
 */

class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>
            = list.map { convertForecastItemToDomain(it) }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast
            = ModelForecast(convertDate(forecast.dt),
            forecast.weather[0].description, forecast.temp.max.toInt(),
            forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}