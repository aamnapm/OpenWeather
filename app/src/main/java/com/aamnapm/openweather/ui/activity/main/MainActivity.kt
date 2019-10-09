package com.aamnapm.openweather.ui.activity.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aamnapm.openweather.R
import com.aamnapm.openweather.config.AppController
import com.aamnapm.openweather.databinding.ActivityMainBinding
import com.aamnapm.openweather.di.netModule
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        mainViewModel.callCurrentWeatherApi()
        Log.e("MainActivity","Main")
    }
}
