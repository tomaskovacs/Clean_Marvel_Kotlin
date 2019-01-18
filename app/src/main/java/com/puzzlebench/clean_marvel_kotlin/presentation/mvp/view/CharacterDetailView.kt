package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view

import android.support.v4.app.DialogFragment
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import java.lang.ref.WeakReference

class CharacterDetailView(fragment: DialogFragment) {

    private val fragmentRef = WeakReference(fragment)

    fun init() {
        val fragment = fragmentRef.get()
        if (fragment != null) {

        }
    }

    fun showToastNoDetailToShow() {
        val fragment = fragmentRef.get()
        if (fragment != null) {
            val message = fragment.context.resources.getString(R.string.message_no_detail_to_show)
            fragment.activity.applicationContext.showToast(message)
        }
    }

    fun showToastNetworkError(error: String) {
        fragmentRef.get()!!.activity.applicationContext.showToast(error)
    }

    fun showCharacterDetail(character: Character) {
        // Show the Dialog Fragment
    }
}