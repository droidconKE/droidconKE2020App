package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.R as AppR
import kotlinx.android.synthetic.main.tab_session.view.*

class SessionsTabAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val sessionDays = mutableListOf<String>()
    private val sessionDates = mutableListOf<String>()
    private val fragmentList = mutableListOf<Fragment>()

    override fun getPageTitle(position: Int): CharSequence? = sessionDates[position]

    fun addFragment(sessionFragment: Fragment, sessionDay: String, sessionDate: String) {
        fragmentList.add(sessionFragment)
        sessionDays.add(sessionDay)
        sessionDates.add(sessionDate)
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    fun getTabView(position: Int): View {
        val tabView = LayoutInflater.from(context).inflate(R.layout.tab_session, null)
        tabView.textViewDayDate.text = sessionDates[position]
        tabView.textViewDayName.text = sessionDays[position]
        tabView.textViewDayName.setTextColor(
            ContextCompat.getColor(
                context,
                AppR.color.colorGreen
            )
        )
        tabView.layoutTabSession.background =
            context.resources.getDrawable(R.drawable.session_card_view_border, null)
        return tabView
    }

    fun getSelectedTabView(position: Int): View {
        val tabView = LayoutInflater.from(context).inflate(R.layout.tab_session, null)
        tabView.textViewDayDate.text = sessionDates[position]
        tabView.textViewDayName.text = sessionDays[position]
        tabView.textViewDayName.setTextColor(Color.BLACK)
        tabView.layoutTabSession.background =
            context.resources.getDrawable(R.drawable.tab_selected, null)
        return tabView
    }

}