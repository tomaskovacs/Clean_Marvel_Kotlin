package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.presenter

import android.view.View
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.SaveCharacterLocalUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.Presenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view.CharecterView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterPresenter(view: CharecterView, private val getChatacterServiceUseCase: GetCharacterServiceUseCase,
                         private val saveCharacterLocalUseCase: SaveCharacterLocalUseCase,
                         val subscriptions: CompositeDisposable) : Presenter<CharecterView>(view) {

    fun init() {
        view.init()
        requestGetCharacters()

        view.setFabClickListener(View.OnClickListener {
            requestGetCharacters()
        })
    }

    private fun requestGetCharacters() {
        val subscription = getChatacterServiceUseCase.invokeCharacters().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ characters ->
            if (characters.isEmpty()) {
                view.showToastNoItemToShow()
            } else {
                view.showCharacters(characters)
                saveCharacterLocalUseCase.saveCharacters(characters)
            }
            view.hideLoading()

        }, { e ->
            view.hideLoading()
            view.showToastNetworkError(e.message.toString())
        })
        subscriptions.add(subscription)
    }
}
