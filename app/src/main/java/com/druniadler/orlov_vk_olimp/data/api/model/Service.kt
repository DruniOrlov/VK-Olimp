package com.druniadler.orlov_vk_olimp.data.api.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Service(
    @Json(name = "description")
    val description: String,
    @Json(name = "icon_url")
    val iconUrl: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "service_url")
    val serviceUrl: String
) : Parcelable