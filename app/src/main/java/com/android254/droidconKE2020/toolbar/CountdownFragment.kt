package com.android254.droidconKE2020.toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.databinding.FragmentCountdownBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.TimeUnit

class CountdownFragment : Fragment() {
    lateinit var binding: FragmentCountdownBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountdownBinding.inflate(inflater, container, false)


        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                val (days, hours, minutes) = getTimeLeft()
                binding.daysValue = "$days"
                binding.hoursValue = "$hours"
                binding.minutesValue = "$minutes"
                delay(1000*30)
            }
        }

        return binding.root
    }

    private fun getTimeLeft(): Triple<Long, Long, Long> {
        val now: Calendar = Calendar.getInstance()
        val droidConDate: Calendar = Calendar.getInstance()
        droidConDate.set(2020, Calendar.AUGUST, 6, 0, 0, 0)

        val diffInMillisec: Long = (droidConDate.timeInMillis - now.timeInMillis)
        var diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec)

        val seconds = diffInSec % 60
        diffInSec /= 60
        val minutes = diffInSec % 60
        diffInSec /= 60
        val hours = diffInSec % 24
        diffInSec /= 24
        val days = diffInSec


        return Triple(days, hours, minutes)
    }
}