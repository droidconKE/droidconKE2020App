package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.models.DaySession
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsClickListener
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsTabAdapter
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import com.android254.droidconKE2020.sessions.utils.ZoomOutPageTransformer
import com.android254.droidconKE2020.sessions.utils.getScheduleDays
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.*
import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.tabLayout
import kotlinx.android.synthetic.main.fragment_sessions.*
import kotlinx.android.synthetic.main.tab_session.view.*
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.sharedViewModel


class BookmarkedSessionsFragment : Fragment(){
    private lateinit var sessionsTabAdapter: SessionsTabAdapter
    private var _binding: FragmentBookmarkedSessionsBinding? = null
    private val binding get() = _binding!!
    private fun injectFeatures() = loadModules
    private val sessionsViewModel: SessionsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkedSessionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeatures()
        observeSessions()
//        sessionsViewModel.fetchBookmarkedSessions()
//        setUpTabs(getScheduleDays())


        binding.switchSavedSessions.setOnCheckedChangeListener { _, isChecked ->
            if(!isChecked){
                goBackToSessions()
            }
        }

        binding.imageBackNavigation.setOnClickListener {
            goBackToSessions()
        }
    }

    private fun observeSessions(){
        sessionsViewModel.sessions.observe(viewLifecycleOwner, { sessions ->
           Log.d("Saved sessions", "size, ${sessions.filter { it.isBookmarked }.size}")

        })
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
        binding.viewPagerSavedSessions.adapter = sessionsTabAdapter
    binding.viewPagerSavedSessions.setPageTransformer(true, ZoomOutPageTransformer())
        binding.tabLayout.setupWithViewPager(viewPagerSavedSessions)
        (0..tabLayout.tabCount).forEach { tabPosition ->
            val tab = tabLayout.getTabAt(tabPosition)
            tab?.let {
                tab.customView = null
                tab.customView = sessionsTabAdapter.getTabView(tabPosition)
            }
        }
        tabLayout.getTabAt(0)?.customView = null
        tabLayout.getTabAt(0)?.customView = sessionsTabAdapter.getSelectedTabView(0)
        viewPagerSavedSessions.addOnPageChangeListener(
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

    private fun goBackToSessions(){
        val fragmentDirections =
            BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment()
        findNavController().navigate(fragmentDirections)

    }

}