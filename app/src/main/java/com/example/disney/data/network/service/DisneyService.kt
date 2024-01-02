package com.example.disney.data.network.service

import com.example.disney.core.Util
import com.example.disney.data.network.client.DisneyApiClient
import com.example.disney.domain.model.Character
import javax.inject.Inject

class DisneyService @Inject constructor(disneyApiClient: DisneyApiClient) {

    private val apiClient = disneyApiClient.getApiClient()

    suspend fun getCharacters(): Result<List<Character>> {
        return try {
            val response = apiClient.getCharacters().data
            val character = response.map { Util.mapResponseToCharacter(it) }
            Result.success(character)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}