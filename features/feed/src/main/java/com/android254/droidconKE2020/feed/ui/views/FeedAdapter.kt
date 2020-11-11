package com.android254.droidconKE2020.feed.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.android254.droidconKE2020.feed.R
import kotlinx.android.synthetic.main.item_feeds.view.*

class FeedAdapter(private val onSharedClicked: (Feed) -> Unit) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private val feeds = mutableListOf<Feed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feeds, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int = feeds.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feed = feeds[position]
        holder.bindFeed(feed)
    }

    fun updateData(list: List<Feed>) {
        feeds.clear()
        feeds.addAll(list)
        notifyDataSetChanged()
    }

    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val content: TextView
        val image: ImageView
        val time: TextView
        val shareButton: ImageButton

        init {
            content = view.content
            image = view.image
            time = view.time
            shareButton = view.shareBtn
        }

        fun bindFeed(feed: Feed) {
            feed.let {
                content.text = it.content
                image.load(it.imageUrl) {
                    transformations(RoundedCornersTransformation(12f))
                }
                time.text = it.time
            }
            shareButton.setOnClickListener {
                onSharedClicked.invoke(feed)
            }
        }
    }
}