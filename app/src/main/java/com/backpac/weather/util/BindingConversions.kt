package com.backpac.weather.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load

object BindingConversions {
    @BindingAdapter("setImage")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        val imageLoader = ImageLoader.Builder(imageView.context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        imageView.load("https://www.metaweather.com/static/img/weather/$url.svg", imageLoader)
    }


    @BindingAdapter("setTemp")
    @JvmStatic
    fun TextView.setTemp(theTemp: Double) {
        this.text = "${theTemp.toInt()}℃"
    }

    @BindingAdapter("setHumidity")
    @JvmStatic
    fun TextView.setHumidity(humidity: Int) {
        this.text = "$humidity%"
    }
}