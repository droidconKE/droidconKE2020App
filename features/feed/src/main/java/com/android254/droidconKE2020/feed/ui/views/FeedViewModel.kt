package com.android254.droidconKE2020.feed.ui.views

import android.content.Context
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.feed.R


class FeedViewModel(private val context: Context) : ViewModel() {
    val feeds = MutableLiveData<List<Feed>>()
    val blank: LiveData<Boolean> = Transformations.map(feeds, Function {
        return@Function it.isEmpty()
    })

    init {
        feeds.value = createDummyData()
    }

    private fun createDummyData(): List<Feed> {
        val list = mutableListOf<Feed>()
        for (i in 0 until 10) {
            list.add(Feed(content = context.getString(R.string.dummy_text), time = "10:5$i"))
        }
        return list
    }
}