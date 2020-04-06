package com.android254.droidconKE2020

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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
    var sessionsHandler :(() -> Unit)? = null

    fun onDestinationChanged(destination: Int, destinationName : String) {
        when (destination) {
            R.id.homeFragment, R.id.authDialog -> setHomeToolbar()
            R.id.feedFragment -> setFeedToolbar()
            R.id.feedBackFragment -> setFeedbackToolbar(destinationName)
            else -> removeAllViews()
        }
    }

    private fun setFeedbackToolbar(destinationName: String) {
        removeAllViews()
        val view = getView(R.layout.feed_toolbar)
        val tvToolbarTitle = view.findViewById<TextView>(R.id.title)
        tvToolbarTitle.text = destinationName
        addView(view)
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
            val view = LayoutInflater.from(context).inflate(R.layout.home_signed_out_toolbar, this, false)
            val droidconIcon = view.findViewById<ImageView>(R.id.imgToolbarLogo)
            droidconIcon.setOnClickListener {
                nightModeHandler?.invoke()
                true
            }
            addView(view)
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
        return view
    }

}