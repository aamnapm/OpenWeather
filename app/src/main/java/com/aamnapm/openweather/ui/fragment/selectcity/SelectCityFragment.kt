package com.aamnapm.openweather.ui.fragment.selectcity


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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


        selectCityViewModel.isCityAvailable.observe(this, Observer {
            if (it) {
                binding.edtCityName.setBackgroundResource(R.drawable.background_edt_city_success)
            } else {
                binding.edtCityName.setError(getString(R.string.city_not_found))
                binding.edtCityName.setBackgroundResource(R.drawable.background_edt_city_error)
            }
        })


        selectCityViewModel.cityName.observe(this, Observer {
            if (it.equals("") || it.equals(" ") || it == null) {
                binding.edtCityName.setError(getString(R.string.city_not_found))
            }
        })


        /**
         * navigate to WeatherFragment with cityName
         */
        binding.btnSubmit.setOnClickListener {
            findNavController()
                .navigate(
                    SelectCityFragmentDirections.actionSelectCityFragmentToWeatherFragment
                        (
                        selectCityViewModel.temperature,
                        selectCityViewModel.cityName.value.toString()
                    )
                )
        }

        return binding.root
    }
}
