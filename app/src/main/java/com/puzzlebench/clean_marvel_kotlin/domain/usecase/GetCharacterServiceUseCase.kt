package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import io.reactivex.Observable

open class GetCharacterServiceUseCase(private val characterServiceImp: CharacterServicesImpl) {

   open fun invokeCharaters(): Observable<List<Character>> = characterServiceImp.getCaracters()

   open fun invokeCharaterDetail(charaterId: Int):
           Observable<List<Character>> = characterServiceImp.getCharacterDetail(charaterId)
}