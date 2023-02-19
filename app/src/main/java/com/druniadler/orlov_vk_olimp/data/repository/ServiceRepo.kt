package com.druniadler.orlov_vk_olimp.data.repository

import com.druniadler.orlov_vk_olimp.data.api.ServicesApi
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.data.api.model.Services
import javax.inject.Inject

class ServiceRepo @Inject constructor(
    private val servicesApi: ServicesApi
) {
    suspend fun getServices():Services {
        return servicesApi.getServices()
    }
}