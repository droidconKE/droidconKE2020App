package com.android254.droidconKE2020.feed.ui.views

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.progress.KProgressBar
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.android254.droidconKE2020.feed.R
import org.hamcrest.Matcher

class FeedScreen : Screen<FeedScreen>() {
    val noFeeds = KTextView { withId(R.id.noFeeds)}
    val progressBar = KProgressBar { withId(R.id.progressBar)}
    val feedsList = KRecyclerView(
            { withId(R.id.feedsList) },
    itemTypeBuilder = {
        itemType(::FeedItem)
    })
}

class FeedItem(parent: Matcher<View>): KRecyclerItem<FeedItem>(parent) {
    val feedImage = KImageView { withId(R.id.image) }
    val feedContent = KTextView { withId(R.id.content) }
    val feedTime = KTextView { withId(R.id.time) }
    val feedShareBtn = KTextView { withId(R.id.shareBtn) }
    val feedTimeIcon = KTextView { withId(R.id.timeIcon) }
}