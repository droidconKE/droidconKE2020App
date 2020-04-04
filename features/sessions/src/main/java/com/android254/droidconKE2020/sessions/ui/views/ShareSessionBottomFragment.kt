package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.ui.views.models.DummySessionDetail
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


internal class ShareSessionBottomFragment() : BottomSheetDialogFragment() {

    constructor(session: DummySessionDetail) : this()


    override fun getTheme(): Int {
        return R.style.Theme_Sessions_BottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.share_session_layout, container, false)
}