package com.example.disney.data.network.client

import com.example.disney.data.network.model.CharacterResponse
import retrofit2.http.GET

interface DisneyApiClientI {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}