package com.example.disney.data

import com.example.disney.data.network.service.DisneyService
import com.example.disney.domain.model.Character
import javax.inject.Inject

class Repository @Inject constructor(private val disneyService: DisneyService) {

    suspend fun getCharacters(): Result<List<Character>> = disneyService.getCharacters()
}