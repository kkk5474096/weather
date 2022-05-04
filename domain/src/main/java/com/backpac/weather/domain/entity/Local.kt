package com.backpac.weather.domain.entity

data class Local(
    val title: String,
    val locationType: String,
    val woeId: Int,
    val latLong: String
)
