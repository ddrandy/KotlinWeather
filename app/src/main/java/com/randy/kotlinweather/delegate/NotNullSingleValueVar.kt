package com.randy.kotlinweather.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/25/17
 * Time: 11:52 AM
 * Description: TODO
 */
class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("Value not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (value == null) value
        else throw IllegalStateException("Value already initialized")
    }

}