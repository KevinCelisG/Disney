package com.example.disney.data.network.service

import com.example.disney.core.Constants
import com.example.disney.core.Util
import com.example.disney.data.network.client.DisneyApiClient
import com.example.disney.domain.model.Character
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisneyService @Inject constructor(disneyApiClient: DisneyApiClient) {

    private val apiClient = disneyApiClient.getApiClient()
    private var currentPage = 1

    suspend fun getCharacters(): Result<List<Character>> {
        return try {
            val response = apiClient.getCharacters(currentPage, Constants.PAGE_SIZE).data
            val character = response.map { Util.mapResponseToCharacter(it) }
            println(response)
            currentPage++
            Result.success(character)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}