package com.aamnapm.openweather.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.aamnapm.openweather.R
import com.aamnapm.openweather.databinding.FragmentSelectCityBinding

/**
 * A simple [Fragment] subclass.
 */
class SelectCityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSelectCityBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_select_city, container, false)

        binding.btnSubmit.setOnClickListener{
                view:View-> Navigation.findNavController(view).navigate(R.id.action_selectCityFragment_to_weatherFragment)
        }

        return binding.root
    }


}
