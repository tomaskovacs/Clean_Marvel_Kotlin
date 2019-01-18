package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.activity

import android.os.Bundle
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.BaseRxActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.presenter.CharacterPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view.CharecterView

open class MainActivity : BaseRxActivity() {

    val getCharacterServiceUseCase = GetCharacterServiceUseCase(CharacterServicesImpl())
    val presenter = CharacterPresenter(CharecterView(this), getCharacterServiceUseCase, subscriptions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init()
    }
}
