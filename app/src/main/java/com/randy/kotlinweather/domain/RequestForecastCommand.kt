package com.randy.kotlinweather.domain

import com.randy.kotlinweather.network.ForecastRequest

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 4:22 PM
 * Description: TODO
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}