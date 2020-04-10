package com.android254.droidconKE2020.feed

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher

class FeedScreen : Screen<FeedScreen>() {
    val blank = KTextView { withId(R.id.noFeeds) }
    val feedsList = KRecyclerView(builder = { withId(R.id.feedsList) },
        itemTypeBuilder = { itemType(::FeedItem) })
}

class FeedItem(parent: Matcher<View>) : KRecyclerItem<FeedItem>(parent) {
    val content: KTextView = KTextView(parent) { withId(R.id.content) }
    val image: KImageView = KImageView(parent) { withId(R.id.image) }
    val shareBtn: KButton = KButton(parent) { withId(R.id.shareBtn) }
}