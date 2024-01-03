package com.example.disney.data.network.client

import com.example.disney.data.network.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DisneyApiClientI {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): CharacterResponse
}