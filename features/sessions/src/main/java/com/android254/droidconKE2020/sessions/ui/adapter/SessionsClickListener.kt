package com.android254.droidconKE2020.sessions.ui.adapter

import android.view.View
import com.android254.droidconKE2020.core.models.SessionUIModel

interface SessionsClickListener {
    fun onSessionClick(sessionUIModel: SessionUIModel)
    fun onSessionSave(sessionUIModel: SessionUIModel, view: View)
}