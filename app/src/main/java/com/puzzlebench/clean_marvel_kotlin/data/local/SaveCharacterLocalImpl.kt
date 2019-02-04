package com.puzzlebench.clean_marvel_kotlin.data.local

import com.puzzlebench.clean_marvel_kotlin.data.mapper.CharacterMapperLocal
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import io.realm.Realm

class SaveCharacterLocalImpl(private val characterMapperLocal: CharacterMapperLocal = CharacterMapperLocal()) {

    fun saveCharacters(characters: List<Character>) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            characterMapperLocal.transform(characters).map { realm.copyToRealmOrUpdate(it) }
            realm.commitTransaction()
        }
    }
}
