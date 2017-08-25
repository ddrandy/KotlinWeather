package com.randy.kotlinweather.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.randy.kotlinweather.R
import com.randy.kotlinweather.domain.Forecast
import com.randy.kotlinweather.engine.glide.GlideApp
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 5:11 PM
 * Description: TODO
 */
class ListViewHolder(view: View, private val itemClick: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(view) {

    fun bindForecast(forecast: Forecast) {
        with(forecast) {
            GlideApp.with(itemView)
                    .load(iconUrl)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(itemView.ivIcon)
            itemView.tvDate.text = date
            itemView.tvDescription.text = description
            itemView.tvMaxTemperature.text = "$high"
            itemView.tvMinTemperature.text = "$low"
            itemView.setOnClickListener { itemClick(this@with) }
        }
    }
}