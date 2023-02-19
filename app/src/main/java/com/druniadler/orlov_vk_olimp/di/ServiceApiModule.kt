package com.druniadler.orlov_vk_olimp.di

import com.druniadler.orlov_vk_olimp.data.api.ApiConstants
import com.druniadler.orlov_vk_olimp.data.api.ServicesApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceApiModule {
    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): ServicesApi{
        return builder.build()
            .create(ServicesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}