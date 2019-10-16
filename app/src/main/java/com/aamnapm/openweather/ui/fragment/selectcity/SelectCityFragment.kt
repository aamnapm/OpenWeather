package com.aamnapm.openweather.ui.fragment.selectcity


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aamnapm.openweather.R
import com.aamnapm.openweather.databinding.FragmentSelectCityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SelectCityFragment : Fragment() {

    /**
     * inject viewModel in SelectCityFragment
     */
    val selectCityViewModel: SelectCityViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSelectCityBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_select_city, container, false)

        binding.viewModel = selectCityViewModel

        binding.setLifecycleOwner(this)


        /**
         * navigate to WeatherFragment with cityName
         */
        binding.btnSubmit.setOnClickListener {
            findNavController()
                .navigate(
                    SelectCityFragmentDirections.actionSelectCityFragmentToWeatherFragment
                        (selectCityViewModel.cityName)
                )
        }

        return binding.root
    }
}
