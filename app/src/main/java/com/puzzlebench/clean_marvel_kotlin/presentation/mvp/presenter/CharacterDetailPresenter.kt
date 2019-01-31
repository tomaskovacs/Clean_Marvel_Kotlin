package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.presenter

import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.Presenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view.CharacterDetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterDetailPresenter(view: CharacterDetailView, private val getChatacterServiceUseCase: GetCharacterServiceUseCase,
                               val subscriptions: CompositeDisposable, val characterId: Int) : Presenter<CharacterDetailView>(view) {

    fun init() {
        view.init()
        requestCharacter(characterId)
    }

    private fun requestCharacter(characterId: Int) {
        val subscription = getChatacterServiceUseCase.invokeCharacterDetail(characterId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe ({ characters ->
            if (characters.isEmpty()) {
                view.showToastNoDetailToShow()
            } else {
                view.showCharacterDetail(characters[0])
            }
        }, { e ->
            view.showToastNetworkError(e.message.toString())
        })
        subscriptions.add(subscription)
    }
}
