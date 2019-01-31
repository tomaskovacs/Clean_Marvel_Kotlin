package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view

import android.support.v4.app.DialogFragment
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.getImageByUrl
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import kotlinx.android.synthetic.main.fragment_character_detail.*
import java.lang.ref.WeakReference

class CharacterDetailView(fragment: DialogFragment) {

    private val fragmentRef = WeakReference(fragment)

    fun init() {
        fragmentRef.get()?.let {
            // Show loading
        }
    }

    fun showToastNoDetailToShow() {
        fragmentRef.get()?.let {
            val message = it.context.resources.getString(R.string.message_no_detail_to_show)
            it.activity.applicationContext.showToast(message)
        }
    }

    fun showToastNetworkError(error: String) {
        fragmentRef.get()?.activity?.applicationContext?.showToast(error)
    }

    fun showCharacterDetail(character: Character) {
        // Show the character details
        fragmentRef.get()?.let {
            val imageUrl = character.thumbnail.path + "." + character.thumbnail.extension
            it.image_character_detail.getImageByUrl(imageUrl)
            it.text_character_detail_name.text = character.name
            it.text_character_detail_description.text = character.description
        }
    }
}
