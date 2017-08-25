package com.randy.kotlinweather.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.randy.kotlinweather.R
import com.randy.kotlinweather.adapter.ForecastListAdapter
import com.randy.kotlinweather.domain.Forecast
import com.randy.kotlinweather.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thu 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 31/17",
            "Sun 6/29 - Sunny - 31/17"
    )

    private val forecastList: RecyclerView get() = find(R.id.rv_forecast_list)
//    private val forecastList get() = findViewById<RecyclerView>(R.id.rv_forecast_list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        forecastList.layoutManager = LinearLayoutManager(this)
    }

    private fun initData() {
//        forecastList.adapter = ForecastListAdapter(items)
        doAsync {
            val result = RequestForecastCommand("518000").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { toast(it.date) }
            }
        }
    }
}
