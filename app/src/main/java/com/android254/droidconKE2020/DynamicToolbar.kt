package com.android254.droidconKE2020

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.android254.droidconKE2020.core.Preferences
import com.google.android.material.appbar.MaterialToolbar
import org.koin.core.KoinComponent
import org.koin.core.inject

class DynamicToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MaterialToolbar(context, attrs, defStyle), KoinComponent {

    val sharedPrefs: Preferences by inject()

    var authHandler: (() -> Unit)? = null
    var feedbackHandler: (() -> Unit)? = null
    var nightModeHandler: (() -> Unit)? = null

    fun onDestinationChanged(destination: Int) {
        when (destination) {
            R.id.homeFragment, R.id.authDialog -> setHomeToolbar()
            R.id.feedFragment -> setFeedToolbar()
            else -> removeAllViews()
        }
    }

    fun setHomeToolbar() {
        removeAllViews()
        if (sharedPrefs.isSignedIn()) {
            val view = getView(R.layout.home_signed_in_toolbar_layout)
            val feedbackBtn = view.findViewById<ConstraintLayout>(R.id.btnFeedback)
            feedbackBtn.setOnClickListener {
                feedbackHandler?.invoke()
            }
            addView(view)
        } else {
            addView(getView(R.layout.home_signed_out_toolbar))
        }
    }

    fun setFeedToolbar() {
        removeAllViews()
        addView(getView(R.layout.feed_toolbar))
    }

    private fun getView(@LayoutRes layoutId: Int): View {
        val view = LayoutInflater.from(context).inflate(layoutId, this, false)
        val authBtn = view.findViewById<ImageView>(R.id.btnToolbarIcon)
        authBtn.setOnClickListener {
            authHandler?.invoke()
        }
        val droidconIcon = view.findViewById<ImageView>(R.id.droidconLogo)
        droidconIcon.setOnLongClickListener {
            nightModeHandler?.invoke()
            true
        }
        return view
    }

}