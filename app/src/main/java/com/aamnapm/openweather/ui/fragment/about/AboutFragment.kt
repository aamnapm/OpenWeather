package com.aamnapm.openweather.ui.fragment.about


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.aamnapm.openweather.R
import com.aamnapm.openweather.databinding.FragmentSelectCityBinding

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSelectCityBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_about, container, false)

        return binding.root
    }
}
