package com.randy.kotlinweather.database

import com.randy.kotlinweather.database.model.CityForecast
import com.randy.kotlinweather.database.model.DayForecast
import com.randy.kotlinweather.database.table.CityForecastTable
import com.randy.kotlinweather.database.table.DayForecastTable
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.select

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 5:08 PM
 * Description: TODO
 */
class ForecastDb(
        val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
        val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? " +
                "AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }
        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }
        if (city != null) dataMapper.convertToDomain(city) else null
    }

    private fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
            })

    private fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
            parseOpt(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
            })
}