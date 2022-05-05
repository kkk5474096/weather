package com.backpac.weather.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.backpac.weather.databinding.ItemHeaderBinding
import com.backpac.weather.databinding.ItemWeatherListBinding
import com.backpac.weather.domain.entity.Weather

class WeatherAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_TYPE -> {
                val binding = ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                HeaderViewHolder(binding)
            }
            else -> {
                val binding = ItemWeatherListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                WeatherViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WeatherViewHolder) {
            holder.bind(items[position - 1])
        }
    }

    override fun getItemCount(): Int = items.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_TYPE
            else -> WEATHER_TYPE
        }
    }

    fun setItems(newItems: List<Weather>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class HeaderViewHolder(
        private val binding: ItemHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class WeatherViewHolder(
        private val binding: ItemWeatherListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.data = weather
        }
    }

    companion object {
        const val HEADER_TYPE = 0
        const val WEATHER_TYPE = 1
    }
}
