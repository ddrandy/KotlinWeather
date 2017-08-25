package com.randy.kotlinweather.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.randy.kotlinweather.R
import com.randy.kotlinweather.adapter.ForecastListAdapter
import com.randy.kotlinweather.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        rvForecastList.layoutManager = LinearLayoutManager(this)
    }

    private fun initData() {
        doAsync {
            val result = RequestForecastCommand("518000").execute()
            uiThread {
                rvForecastList.adapter = ForecastListAdapter(result) { toast(it.date) }
            }
        }
    }
}
