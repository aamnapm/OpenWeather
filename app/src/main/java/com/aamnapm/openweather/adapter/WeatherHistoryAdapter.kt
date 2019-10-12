package com.aamnapm.openweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aamnapm.openweather.R
import com.aamnapm.openweather.model.Weather

class WeatherHistoryAdapter :
    ListAdapter<Weather, WeatherHistoryAdapter.WeatherViewHolder>(CallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder.from(parent)
    }

    //    override fun getItemCount() = 5
//
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
//        getItem(position)
        holder.bind()
    }

    class WeatherViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val txt: TextView = itemView.findViewById(R.id.txt)

        fun bind() {
            txt.text = "ali"
        }


        companion object {
            fun from(parent: ViewGroup): WeatherViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_weather_history, parent, false)
                return WeatherViewHolder(view)
            }
        }
    }

    class CallBack : DiffUtil.ItemCallback<Weather>() {

        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }

    }
}