package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.sessions.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.filter_layout.*

internal class BottomSheetFilterFragment : Fragment() {
    private val roomsTestList = mutableListOf<String>()
    private val levelsTestList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.filter_layout, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (0..3).forEach {
            roomsTestList.add("Room $it")
        }
        roomsTestList.forEach { roomName ->
            val chip =
                LayoutInflater.from(requireContext()).inflate(R.layout.filter_chip, null) as Chip
            chip.text = roomName
            roomsChipGroup.addView(chip)
        }
        (0..2).forEach {
            levelsTestList.add("Advanced")
        }
        levelsTestList.forEach {
            val chip =
                LayoutInflater.from(requireContext()).inflate(R.layout.filter_chip, null) as Chip
            chip.text = it
            levelChipGroup.addView(chip)
        }
        buttonCancel.setOnClickListener {

        }
    }
}