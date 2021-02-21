package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionsBinding
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.models.DaySession
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsTabAdapter
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import com.android254.droidconKE2020.sessions.utils.ZoomOutPageTransformer
import com.android254.droidconKE2020.sessions.utils.getScheduleDays
import org.koin.android.viewmodel.ext.android.sharedViewModel

internal class SessionsFragment : Fragment(R.layout.fragment_sessions) {
    private lateinit var sessionsTabAdapter: SessionsTabAdapter
    private val sessionsViewModel: SessionsViewModel by sharedViewModel()
    private var _binding: FragmentSessionsBinding? = null
    private val binding get() = _binding!!
    private fun injectFeatures() = loadModules
    private var day = "Day 1"
    private var showBookmarked = false

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
        observeDayPosition(getScheduleDays())
        showBookmarkedSessions()
    }

    private fun observeDayPosition(daySessions: List<DaySession>) {
        sessionsViewModel.showBookMarkedSessionsPair.observe(viewLifecycleOwner) { apair ->
            showBookmarked = apair.first
            val day = apair.second
            val position = daySessions.indexOf(daySessions.first{daySession -> (daySession.dayText == day) })
            highlightTab(position)
        }
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
        val viewPagerSessions = binding.viewPagerSessions
        val tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPagerSessions)
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
                    day =  daySessions[position].dayText
                    sessionsViewModel.showBookMarkedSessionsPair.postValue(Pair(showBookmarked, day))

                }
            }
        )
    }

    private fun highlightTab(position: Int) {
        val tabLayout = binding.tabLayout
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

    private fun showBookmarkedSessions() {
        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            val apair = Pair(isChecked, day)
            sessionsViewModel.showBookMarkedSessionsPair.postValue(apair)
        }
    }
}