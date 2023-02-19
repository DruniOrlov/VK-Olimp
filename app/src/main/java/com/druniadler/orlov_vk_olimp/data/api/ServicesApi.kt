package com.druniadler.orlov_vk_olimp.data.api

import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.data.api.model.Services
import retrofit2.http.GET

interface ServicesApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getServices():Services

}