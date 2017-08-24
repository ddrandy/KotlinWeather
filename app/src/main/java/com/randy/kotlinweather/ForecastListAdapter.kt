package com.randy.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 8/24/17
 * Time: 1:54 PM
 * Description: TODO
 */
class ForecastListAdapter(private val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder
            = ListViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ListViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
