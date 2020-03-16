package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsTabAdapter
import kotlinx.android.synthetic.main.fragment_sessions.*

class SessionsFragment : Fragment(R.layout.fragment_sessions) {

    private lateinit var sessionsTabAdapter: SessionsTabAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()
        filterLayout.setOnClickListener {
            val bottomSheetFilterFragment = BottomSheetFilterFragment()
            bottomSheetFilterFragment.show(parentFragmentManager, "Filter Fragment")
        }
    }

    private fun setUpTabs() {
        sessionsTabAdapter = SessionsTabAdapter(childFragmentManager, requireContext())
        sessionsTabAdapter.addFragment(DaySessions.newInstance("Day 1"), "Day 1", "06")
        sessionsTabAdapter.addFragment(DaySessions.newInstance("Day 2"), "Day 2", "07")
        sessionsTabAdapter.addFragment(DaySessions.newInstance("Day 2"), "Day 3", "08")
        viewPagerSessions.adapter = sessionsTabAdapter
        tabLayout.setupWithViewPager(viewPagerSessions)
        (0..tabLayout.tabCount).forEach { tabPosition ->
            val tab = tabLayout.getTabAt(tabPosition)
            tab?.let {
                tab.customView = null
                tab.setCustomView(sessionsTabAdapter.getTabView(tabPosition))
            }
        }
        tabLayout.getTabAt(0)?.customView = null
        tabLayout.getTabAt(0)?.customView = sessionsTabAdapter.getSelectedTabView(0)
        viewPagerSessions.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                highlightTab(position)
            }

        })
    }

    private fun highlightTab(position: Int) {
        (0..tabLayout.tabCount).forEach { tabPosition ->
            val tab = tabLayout.getTabAt(tabPosition)
            tab?.let {
                tab.customView = null
                tab.setCustomView(sessionsTabAdapter.getTabView(tabPosition))
            }
        }
        val tab = tabLayout.getTabAt(position)
        tab?.let {
            tab.customView = null
            tab.customView = sessionsTabAdapter.getSelectedTabView(position)
        }
    }


}