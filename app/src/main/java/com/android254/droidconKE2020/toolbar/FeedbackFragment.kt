package com.android254.droidconKE2020.toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.R
import com.android254.droidconKE2020.databinding.FragmentFeedbackBinding

class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        binding.setGiveFeedback { feedback() }

        return binding.root
    }

    private fun feedback() {
        val navHostFragment =
            parentFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navController.navigate(R.id.feedBackFragment)
    }

}