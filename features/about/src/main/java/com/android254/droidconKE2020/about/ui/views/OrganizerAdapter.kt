package com.android254.droidconKE2020.about.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.about.R
import kotlinx.android.synthetic.main.item_organizer.view.*

class OrganizerAdapter(private val onClicked: (Organizer) -> Unit) :

    RecyclerView.Adapter<OrganizerAdapter.OrganizerViewHolder>() {

    private val organizers = mutableListOf<Organizer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_organizer, parent, false)
        return OrganizerViewHolder(view)
    }

    override fun getItemCount(): Int = organizers.size

    override fun onBindViewHolder(holder: OrganizerViewHolder, position: Int) {
        val organizer = organizers[position]
        holder.bindOrganizer(organizer)
    }

    fun updateData(list: List<Organizer>) {
        organizers.clear()
        organizers.addAll(list)
        notifyDataSetChanged()
    }

    inner class OrganizerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val organizerImg: ImageView
        val nametxt: TextView
        val titletxt: TextView

        init {
            organizerImg = view.img_organizer
            nametxt = view.organizer_name
            titletxt = view.organizer_title
        }

        fun bindOrganizer(organizer: Organizer) {
            with(organizer) {
                nametxt.text = name
                titletxt.text = title
            }
        }
    }
}