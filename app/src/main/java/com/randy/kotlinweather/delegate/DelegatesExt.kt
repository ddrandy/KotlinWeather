package com.randy.kotlinweather.delegate

import kotlin.properties.ReadWriteProperty

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 1:38 PM
 * Description: TODO
 */
object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}