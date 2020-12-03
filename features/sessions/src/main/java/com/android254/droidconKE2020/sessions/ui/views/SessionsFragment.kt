package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionsBinding
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsTabAdapter
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.models.DaySession
import com.android254.droidconKE2020.sessions.utils.ZoomOutPageTransformer
import com.android254.droidconKE2020.sessions.utils.getScheduleDays
import kotlinx.android.synthetic.main.fragment_sessions.*

internal class SessionsFragment : Fragment(R.layout.fragment_sessions) {
    private lateinit var sessionsTabAdapter: SessionsTabAdapter
    private var _binding: FragmentSessionsBinding? = null
    private val binding get() = _binding!!
    private fun injectFeatures() = loadModules

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeatures()
        super.onViewCreated(view, savedInstanceState)
        setUpTabs(getScheduleDays())
    }

    private fun setUpTabs(daySessions: List<DaySession>) {
        sessionsTabAdapter = SessionsTabAdapter(childFragmentManager, requireContext())
        daySessions.forEach { daySession ->
            sessionsTabAdapter.addFragment(
                DaySessionsFragment.newInstance(daySession.dayText),
                daySession.dayText,
                daySession.date
            )
        }
        binding.viewPagerSessions.adapter = sessionsTabAdapter
        binding.viewPagerSessions.setPageTransformer(true, ZoomOutPageTransformer())
        binding.tabLayout.setupWithViewPager(viewPagerSessions)
        (0..tabLayout.tabCount).forEach { tabPosition ->
            val tab = tabLayout.getTabAt(tabPosition)
            tab?.let {
                tab.customView = null
                tab.customView = sessionsTabAdapter.getTabView(tabPosition)
            }
        }
        tabLayout.getTabAt(0)?.customView = null
        tabLayout.getTabAt(0)?.customView = sessionsTabAdapter.getSelectedTabView(0)
        viewPagerSessions.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    highlightTab(position)
                }
            }
        )
    }

    private fun highlightTab(position: Int) {
        (0..tabLayout.tabCount).forEach { tabPosition ->
            val tab = tabLayout.getTabAt(tabPosition)
            tab?.let {
                tab.customView = null
                tab.customView = sessionsTabAdapter.getTabView(tabPosition)
            }
        }
        val tab = tabLayout.getTabAt(position)
        tab?.let {
            tab.customView = null
            tab.customView = sessionsTabAdapter.getSelectedTabView(position)
        }
    }
}