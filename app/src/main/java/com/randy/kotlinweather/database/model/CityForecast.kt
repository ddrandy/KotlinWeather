package com.randy.kotlinweather.database.model

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 3:59 PM
 * Description: TODO
 */
class CityForecast(val map: MutableMap<String, Any?>,
                   val dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>) :
            this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }
}