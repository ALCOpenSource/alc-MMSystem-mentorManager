package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnBroadcastClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnMessageClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener

class DiscussionForumAdapter(private val discussions: Array<String>)
    : RecyclerView.Adapter<DiscussionForumAdapter.DiscussionForumViewHolder>() {

    private lateinit var listener1: OnMessageClickListener
    private lateinit var listener2: OnBroadcastClickListener
    private lateinit var listener3: OnShareClickListener

    fun setOnMessageClickListener(listener: OnMessageClickListener) {
        listener1 = listener
    }

    fun setOnBroadcastClickListener(listener: OnBroadcastClickListener) {
        listener2 = listener
    }

    fun setOnShareClickListener(listener: OnShareClickListener) {
        listener3 = listener
    }

    inner class DiscussionForumViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val nName = view.findViewById<TextView>(R.id.forumName)
        private val message = view.findViewById<ImageView>(R.id.forumIconMess)
        private val broadcast = view.findViewById<ImageView>(R.id.forumIconBroad)
        private val share = view.findViewById<ImageView>(R.id.forumIconShare)

        init {
            message.setOnClickListener {
                listener1.onMessageClick()
            }

            broadcast.setOnClickListener {
                listener2.onBroadcastClick()
            }

            share.setOnClickListener {
                listener3.onShareClick()
            }
        }

        fun bind(name: String) {
            nName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscussionForumViewHolder {
        val view = LayoutInflater.from(parent.context, )
            .inflate(R.layout.forum_item, parent, false)
        return DiscussionForumViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscussionForumViewHolder, position: Int) {
        val current = discussions[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int = discussions.size
}