package com.randy.kotlinweather.database.model

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 4:00 PM
 * Description: TODO
 */
class DayForecast(var map: MutableMap<String, Any?>) {

    var _id: Long by map
    var date: Long by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: Long, description: String, high: Int, low: Int,
                iconUrl: String, cityId: Long) : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}