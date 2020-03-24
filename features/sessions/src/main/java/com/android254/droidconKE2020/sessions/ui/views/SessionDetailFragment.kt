package com.android254.droidconKE2020.sessions.ui.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionDetailBinding


/**
 * A simple [Fragment] subclass.
 */
class SessionDetailFragment : Fragment(R.layout.fragment_session_detail){
    private var _binding : FragmentSessionDetailBinding? = null
    private val binding  get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewSpeaker.setOnClickListener {
            val speakerDetailsAction = SessionDetailFragmentDirections.actionSessionDetailsFragmentToSpeakerDetailsFragment()
            findNavController().navigate(speakerDetailsAction)
        }
    }
}
