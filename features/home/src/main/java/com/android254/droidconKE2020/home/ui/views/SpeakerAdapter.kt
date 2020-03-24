package com.android254.droidconKE2020.home.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView
import com.android254.droidconKE2020.home.R
import kotlinx.android.synthetic.main.item_speaker.view.*

typealias ClickListener = (Speaker) -> Unit
class SpeakerAdapter(private val onClicked: ClickListener) :
    RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>() {

    private val speakers = mutableListOf<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false)
        return SpeakerViewHolder(view, onClicked)
    }

    override fun getItemCount(): Int = speakers.size

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        val speaker = speakers[position]
        holder.bindSpeaker(speaker)
    }

    fun updateData(list: List<Speaker>) {
        speakers.clear()
        speakers.addAll(list)
        notifyDataSetChanged()
    }

    inner class SpeakerViewHolder(view: View,onClicked : ClickListener) : RecyclerView.ViewHolder(view) {
        val speakerImg: ShapedImageView
        val nameTxt: TextView

        init {
            speakerImg = view.speakerImg
            nameTxt = view.name
        }

        fun bindSpeaker(speaker: Speaker) {
            with(speaker) {
                nameTxt.text = name
                itemView.setOnClickListener {
                    onClicked(this)
                }
            }
        }
    }
}