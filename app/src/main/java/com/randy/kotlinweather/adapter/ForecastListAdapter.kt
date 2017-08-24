package com.randy.kotlinweather.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.randy.kotlinweather.domain.ForecastList

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 1:54 PM
 * Description: TODO
 */
class ForecastListAdapter(private val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder
            = ListViewHolder(TextView(parent.context))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ListViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
