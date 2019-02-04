package com.puzzlebench.clean_marvel_kotlin.presentation.mvp.view

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.activity.MainActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.fragment.CharacterDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class CharecterView(activity: MainActivity) {

    private val activityRef = WeakReference(activity)
    private val SPAN_COUNT = 1
    var adapter = CharacterAdapter {character ->
        val fragment = CharacterDetailFragment.newInstance(character.id)
        fragment.show(activity.supportFragmentManager, "CharacterDetailDialog")
    }

    fun init() {
        val activity = activityRef.get()
        activity?.let {
            // RecyclerView setup
            it.recycleView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
            it.recycleView.adapter = adapter
            showLoading()
        }
    }

    fun setFabClickListener(listener: View.OnClickListener) {
        activityRef.get()?.refreshFab?.setOnClickListener(listener)
    }

    fun showToastNoItemToShow() {
        val activity = activityRef.get()
        activity?.let {
            val message = activity.baseContext.resources.getString(R.string.message_no_items_to_show)
            it.applicationContext.showToast(message)

        }
    }

    fun showToastNetworkError(error: String) {
        activityRef.get()?.applicationContext?.showToast(error)
    }

    fun hideLoading() {
        activityRef.get()?.progressBar?.visibility = View.GONE
    }

    fun showCharacters(characters: List<Character>) {
        adapter.data = characters
        adapter.notifyDataSetChanged()
    }

    fun showLoading() {
        activityRef.get()?.progressBar?.visibility = View.VISIBLE
    }
}
