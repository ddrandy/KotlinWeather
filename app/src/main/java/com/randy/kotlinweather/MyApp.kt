package com.randy.kotlinweather

import android.app.Application
import timber.log.Timber

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 3:25 PM
 * Description: TODO
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}