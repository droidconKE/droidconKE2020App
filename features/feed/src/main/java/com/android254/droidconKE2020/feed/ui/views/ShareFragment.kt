package com.android254.droidconKE2020.feed.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.android254.droidconKE2020.feed.R
import kotlinx.android.synthetic.main.fragment_share.*


class ShareFragment : RoundedBottomSheetFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        twitterShare.setOnClickListener {
            Toast.makeText(context, "Twitter clicked", Toast.LENGTH_SHORT).show()
        }
        fbShare.setOnClickListener {
            Toast.makeText(context, "Fb clicked", Toast.LENGTH_SHORT).show()
        }
        whatsappShare.setOnClickListener {
            Toast.makeText(context, "WhatsApp clicked", Toast.LENGTH_SHORT).show()
        }
        telegramShare.setOnClickListener {
            Toast.makeText(context, "Telegram clicked", Toast.LENGTH_SHORT).show()
        }
    }

}
