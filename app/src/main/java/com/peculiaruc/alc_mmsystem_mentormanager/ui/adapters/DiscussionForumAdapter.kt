package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ForumItemBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorListRecyclerviewItemBinding
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnBroadcastClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnMessageClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener

class DiscussionForumAdapter(private val discussions: Array<String>)
    : RecyclerView.Adapter<DiscussionForumAdapter.ViewHolder>() {


inner class ViewHolder(val binding: ForumItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ForumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = discussions[position]

        with(holder){
            with(discussions[position]){
                binding.forumName.text=current
                binding.forumIconMess.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_discussionForumFragment_to_commentsFragment)
                }
                binding.forumMore.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_discussionForumFragment_to_editPostFragment)
                }
                binding.forumIconBroad.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_discussionForumFragment_to_fragment_mm_chat2)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return discussions.size
    }
}


