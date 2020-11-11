package com.android254.droidconKE2020.about.ui.views

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.android254.droidconKE2020.about.R

class AboutScreen : Screen<AboutScreen>() {
    val aboutImage = KImageView { withId(R.id.about_page_image) }
    val aboutContent = KTextView { withId(R.id.txt_about_content) }
}