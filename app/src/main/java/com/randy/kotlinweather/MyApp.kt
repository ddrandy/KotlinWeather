package com.randy.kotlinweather

import android.app.Application
import com.randy.kotlinweather.delegate.DelegatesExt
import timber.log.Timber

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 3:25 PM
 * Description: TODO
 */
class MyApp : Application() {
    companion object {
        var instance: MyApp by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
    }
}