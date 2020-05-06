package com.android254.droidconKE2020.about.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OrganizerAdapter {
            val organizerDetailsDirections =
                AboutFragmentDirections.actionAboutFragmentToOrganizerDetailsFragment()
            findNavController().navigate(organizerDetailsDirections)
        }
        binding.organizersList.adapter = adapter
        adapter.updateData(createDummyData()) // TODO Remove use of dummy data
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun createDummyData(): List<Organizer> {
        val list = mutableListOf<Organizer>()
        for (i in 0 until 10) {
            list.add(
                Organizer(
                    name = context!!.getString(R.string.organizer_name),
                    title = context!!.getString(R.string.organizer_title)
                )
            )
        }
        return list
    }
}