package com.randy.kotlinweather.domain

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 4:05 PM
 * Description: TODO
 */

interface Command<out T> {
    fun execute(): T
}