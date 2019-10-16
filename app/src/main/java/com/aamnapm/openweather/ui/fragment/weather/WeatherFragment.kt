package com.aamnapm.openweather.ui.fragment.weather


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.aamnapm.openweather.R
import com.aamnapm.openweather.databinding.FragmentWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class WeatherFragment : Fragment() {


    /**
     * inject viewModel in SelectCityFragment
     */
    val weatherViewModel: WeatherViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWeatherBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)

        var arg = arguments?.let { WeatherFragmentArgs.fromBundle(it) }

        binding.viewModel = weatherViewModel

        //call api
        weatherViewModel.callCurrentWeatherApi(arg?.units.toString(),arg?.city.toString())

        weatherViewModel.successResponse.observe(this, Observer {
            Log.e("WeatherFragment", "successResponse " + it)
        })

        weatherViewModel.errorResponse.observe(this, Observer {
            Log.e("WeatherFragment", "errorResponse " + it)
        })

        weatherViewModel.onLoading.observe(this, Observer {

            if (it) {
                binding.prg.visibility = View.VISIBLE
                binding.layoutHistory.visibility = View.INVISIBLE
                binding.layoutTodayWeather.visibility = View.INVISIBLE
            } else {
                binding.prg.visibility = View.INVISIBLE
                binding.layoutHistory.visibility = View.VISIBLE
                binding.layoutTodayWeather.visibility = View.VISIBLE
            }
        })

        binding.setLifecycleOwner(this)

        return binding.root
    }
}