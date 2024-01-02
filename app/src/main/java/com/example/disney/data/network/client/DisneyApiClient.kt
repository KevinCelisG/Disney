package com.example.disney.data.network.client

import com.example.disney.core.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisneyApiClient @Inject constructor() {

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiClient(): DisneyApiClientI = getRetrofit().create(DisneyApiClientI::class.java)
}