package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.local.SaveCharacterLocalImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character

class SaveCharacterLocalUseCase(private val saveCharacterLocalImpl: SaveCharacterLocalImpl) {

    fun saveCharacters(characters: List<Character>) = saveCharacterLocalImpl.saveCharacters(characters)
}
