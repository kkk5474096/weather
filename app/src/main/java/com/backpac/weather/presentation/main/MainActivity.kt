package com.backpac.weather.presentation.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.backpac.weather.R
import com.backpac.weather.databinding.ActivityMainBinding
import com.backpac.weather.presentation.main.adapter.MyDecoration
import com.backpac.weather.presentation.main.adapter.WeatherAdapter
import com.backpac.weather.ui.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: WeatherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initView()
        initAdapter()
        observe()
    }

    private fun initData() {
        viewModel.getWeather()
    }

    private fun initView() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getWeather()
        }
    }


    private fun initAdapter() {
        adapter = WeatherAdapter()
        binding.rvWeather.addItemDecoration(MyDecoration(4, Color.BLACK))
        binding.rvWeather.adapter = adapter

    }

    private fun observe() {
        viewModel.weatherResultList.observe(this) {
            binding.swipeRefresh.isRefreshing = false
            binding.pbLoading.isVisible = false
            adapter.setItems(it)
        }
        viewModel.isLoading.observe(this) {
            binding.rvWeather.isVisible = !it
        }
    }
}