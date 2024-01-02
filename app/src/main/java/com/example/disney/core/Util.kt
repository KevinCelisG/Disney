package com.example.disney.core

import com.example.disney.data.network.model.Data
import com.example.disney.domain.model.Character

class Util {

    companion object {
        fun mapResponseToCharacter(data: Data): Character = Character(data.imageUrl, data.name)
    }
}