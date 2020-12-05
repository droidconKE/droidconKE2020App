package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionsBinding


class BookmarkedSessionsFragment : Fragment() {
    private var _binding: FragmentBookmarkedSessionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkedSessionsBinding.inflate(inflater, container, false)
        return _binding!!.root
    }


}