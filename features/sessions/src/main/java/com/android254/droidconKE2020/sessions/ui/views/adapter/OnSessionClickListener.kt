package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.view.View


class SessionClickListener(val clickListener: (sessionId: Long) -> Unit) {
    fun onClick(session: DummySession) = clickListener(session.sessionId)
}

class SaveSessionListener(val saveListener: (session: DummySession, view: View) -> Unit) {
    fun onSave(session: DummySession, view: View) = saveListener(session, view)
}
