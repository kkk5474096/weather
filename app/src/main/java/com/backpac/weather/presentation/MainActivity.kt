package com.backpac.weather.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.backpac.weather.R
import com.backpac.weather.databinding.ActivityMainBinding
import com.backpac.weather.ui.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}