package com.randy.kotlinweather.engine.glide

import android.content.Context

import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 5:42 PM
 * Description: TODO
 */

@GlideModule
class MyAppGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        builder!!.setMemoryCache(LruResourceCache(5 * 1024 * 1024))
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}
