package com.randy.kotlinweather.network

import com.google.gson.Gson
import com.randy.kotlinweather.data.ForecastResult
import timber.log.Timber
import java.net.URL

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 2:38 PM
 * Description: TODO
 */
class ForecastRequest(private val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}