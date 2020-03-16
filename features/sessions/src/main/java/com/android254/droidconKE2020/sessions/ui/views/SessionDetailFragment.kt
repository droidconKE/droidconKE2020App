package com.android254.droidconKE2020.sessions.ui.views


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.api.load
import coil.request.CachePolicy
import com.android254.droidconKE2020.sessions.R
import kotlinx.android.synthetic.main.fragment_session_detail.*

/**
 * A simple [Fragment] subclass.
 */
class SessionDetailFragment : Fragment(R.layout.fragment_session_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageViewSpeaker.load("https://content.fortune.com/wp-content/uploads/2018/07/gettyimages-961697338.jpg") {
            crossfade(false)
            networkCachePolicy(CachePolicy.ENABLED)
            placeholder(R.drawable.ic_droidcon_logo)
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
