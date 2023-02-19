package com.druniadler.orlov_vk_olimp.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Services(
    @Json(name = "items")
    val services: List<Service>
)