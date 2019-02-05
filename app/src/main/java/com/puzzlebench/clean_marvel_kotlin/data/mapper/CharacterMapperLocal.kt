package com.puzzlebench.clean_marvel_kotlin.data.mapper

import com.puzzlebench.clean_marvel_kotlin.data.local.model.RCharacter
import com.puzzlebench.clean_marvel_kotlin.data.local.model.RThumbnail
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail

open class CharacterMapperLocal: BaseMapperRepository<Character, RCharacter> {

    override fun transform(type: Character) = RCharacter(
            type.id,
            type.name,
            type.description,
            transformToRThumbnail(type.thumbnail)
    )

    override fun transformToResponse(type: RCharacter) = Character(
            type.id,
            type.name,
            type.description,
            transformToThumbnail(type.rThumbnail)
    )

    fun transformToRThumbnail(thumbnail: Thumbnail): RThumbnail
        = RThumbnail(
        thumbnail.path,
        thumbnail.extension
    )

    fun transformToThumbnail(RThumbnail: RThumbnail) = Thumbnail(
            RThumbnail.path,
            RThumbnail.extension
    )

    fun transform(listCharacters: List<Character>) = listCharacters.map { transform(it) }
}
