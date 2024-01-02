package com.example.disney.domain.useCases

import com.example.disney.data.Repository
import com.example.disney.domain.model.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(): Result<List<Character>> = repository.getCharacters()
}