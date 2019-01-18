package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.BaseRxDialogFragment
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.presenter.CharacterDetailPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view.CharacterDetailView


private const val ARG_CHARACTER_ID = "characterId"

class CharacterDetailFramgent : BaseRxDialogFragment() {

    val getCharacterServiceUseCase = GetCharacterServiceUseCase(CharacterServicesImpl())
    val presenter = CharacterDetailPresenter(CharacterDetailView(this), getCharacterServiceUseCase, subscriptions)

    companion object {
        fun newInstance(characterId: Int) =
                CharacterDetailFramgent().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_CHARACTER_ID, characterId)
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        presenter.init()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_character_detail, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }
}
