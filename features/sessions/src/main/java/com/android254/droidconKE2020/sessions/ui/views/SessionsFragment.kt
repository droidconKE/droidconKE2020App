package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionsBinding
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsTabAdapter
import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
import com.android254.droidconKE2020.sessions.ui.views.models.DaySession
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionsViewModel
import kotlinx.android.synthetic.main.fragment_sessions.*
import org.koin.android.viewmodel.ext.android.viewModel

internal class SessionsFragment : Fragment(R.layout.fragment_sessions) {
    private lateinit var sessionsTabAdapter: SessionsTabAdapter
    private var _binding: FragmentSessionsBinding? = null
    private val binding get() = _binding!!
    private fun injectFeatures() = loadModules
    private val sessionsViewModel: SessionsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeatures()
        super.onViewCreated(view, savedInstanceState)
        observeDaySessions()
        getDaySessions()
        binding.filterLayout.setOnClickListener {
            findNavController().navigate(SessionsFragmentDirections.actionSessionsFragmentToFilterBottomSheet())
        }
    }

    private fun observeDaySessions() {
        sessionsViewModel.daySessions.observe(viewLifecycleOwner, Observer { daySessions ->
            if (daySessions.isNotEmpty()) {
                setUpTabs(daySessions)
            }
        })
    }

    private fun getDaySessions() {
        sessionsViewModel.getDaySessions()
    }

    private fun setUpTabs(daySessions: List<DaySession>) {
        sessionsTabAdapter = SessionsTabAdapter(childFragmentManager, requireContext())
        daySessions.forEach { daySession ->
            sessionsTabAdapter.addFragment(
                DaySessions.newInstance(daySession.dayText),
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
                tab.setCustomView(sessionsTabAdapter.getTabView(tabPosition))
            }
        }
        tabLayout.getTabAt(0)?.customView = null
        tabLayout.getTabAt(0)?.customView = sessionsTabAdapter.getSelectedTabView(0)
        viewPagerSessions.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

class ZoomOutPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 1 -> { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
                    val horzMargin = pageWidth * (1 - scaleFactor) / 2
                    translationX = if (position < 0) {
                        horzMargin - vertMargin / 2
                    } else {
                        horzMargin + vertMargin / 2
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // Fade the page relative to its size.
                    alpha = (MIN_ALPHA +
                            (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }
    }
}