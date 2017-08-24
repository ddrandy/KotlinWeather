package com.randy.kotlinweather.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.randy.kotlinweather.R
import com.randy.kotlinweather.domain.Forecast
import org.jetbrains.anko.find

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 5:11 PM
 * Description: TODO
 */
class ListViewHolder(view: View, private val clickListener: ForecastListAdapter.OnItemClickListener) :
        RecyclerView.ViewHolder(view) {
    private val ivIcon: ImageView = view.find(R.id.iv_icon)
    private val tvDate: TextView = view.find(R.id.tv_date)
    private val tvDescription: TextView = view.find(R.id.tv_description)
    private val tvMaxTemperature: TextView = view.find(R.id.tv_max_temperature)
    private val tvMinTemperature: TextView = view.find(R.id.tv_min_temperature)

    fun bindForecast(forecast: Forecast) {
        with(forecast) {
            Glide.with(itemView)
                    .load(iconUrl)
                    .into(ivIcon)
            tvDate.text = date
            tvDescription.text = description
            tvMaxTemperature.text = "$high"
            tvMinTemperature.text = "$low"
            itemView.setOnClickListener { clickListener }
        }
    }
}