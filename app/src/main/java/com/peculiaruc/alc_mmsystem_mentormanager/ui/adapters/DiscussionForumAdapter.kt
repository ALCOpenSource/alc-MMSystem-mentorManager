package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.content.Context
import android.graphics.BlendModeColorFilter
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ForumItemBinding
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnBookmarkClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnMessageClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDeleteClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnEditClickListener

class DiscussionForumAdapter(private val context: Context, private val discussions: Array<String>)
    : RecyclerView.Adapter<DiscussionForumAdapter.ViewHolder>() {

    private lateinit var deleteListener: OnDeleteClickListener
    private lateinit var messageListener: OnMessageClickListener
    private lateinit var bookmarkListener: OnBookmarkClickListener
    private lateinit var editListener: OnEditClickListener

    fun setOnDeleteClickListener(mDeleteClickListener: OnDeleteClickListener) {
        deleteListener = mDeleteClickListener
    }
    fun setOnMessageClickListener(mMessageClickListener: OnMessageClickListener) {
        messageListener = mMessageClickListener
    }
    fun setOnBookmarkClickListener(mBookmarkClickListener: OnBookmarkClickListener) {
        bookmarkListener = mBookmarkClickListener
    }
    fun setOnEditClickListener(mEditClickListener: OnEditClickListener) {
        editListener = mEditClickListener
    }


inner class ViewHolder(val binding: ForumItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val view = binding.root

    init {
        binding.forumMore.setOnClickListener {
            binding.forumMoreCard.visibility = View.VISIBLE
        }

        binding.forumIconMess.setOnClickListener {
            messageListener.onMessageClick()
        }

        binding.forumIconBookmark.setOnClickListener {
            bookmarkListener.onBookmarkClick()
            binding.forumIconBookmark.setColorFilter(ContextCompat.getColor(context, R.color.mms_pry_2))
        }

        binding.forumEdit.setOnClickListener {
            editListener.onEditClick()
            binding.forumMoreCard.visibility = View.INVISIBLE
        }

        binding.forumDelete.setOnClickListener {
            deleteListener.onDeleteClick()
            binding.forumMoreCard.visibility = View.INVISIBLE
        }

        binding.forumUpIcon.setOnClickListener {
            binding.forumMoreCard.visibility = View.INVISIBLE
        }

        view.setOnClickListener {
            binding.forumMoreCard.visibility = View.INVISIBLE
        }
    }

    fun bind(title: String) {
        binding.forumName.text = title
    }
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ForumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = discussions[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return discussions.size
    }
}

