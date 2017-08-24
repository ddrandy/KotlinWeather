package com.randy.kotlinweather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.randy.kotlinweather.R
import com.randy.kotlinweather.domain.Forecast
import com.randy.kotlinweather.domain.ForecastList

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 1:54 PM
 * Description: TODO
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val clickListener: OnItemClickListener) :
        RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ListViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

}
