package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.CommentItemBinding
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDeleteClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnEditClickListener

class CommentAdapter(private val comments: Array<String>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    private lateinit var deleteListener: OnDeleteClickListener
    private lateinit var editListener: OnEditClickListener

    fun setOnDeleteClickListener(mDeleteClickListener: OnDeleteClickListener) {
        deleteListener = mDeleteClickListener
    }

    fun setOnEditClickListener(mEditClickListener: OnEditClickListener) {
        editListener = mEditClickListener
    }

    inner class CommentViewHolder(val binding: CommentItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(name: String) {
            binding.commentName.text = name
        }

        init {
            binding.commentMore.setOnClickListener {
                binding.commentMoreCard.visibility = View.VISIBLE
            }

            binding.commentArrowUp.setOnClickListener {
                binding.commentMoreCard.visibility = View.INVISIBLE
            }

            binding.commentEdit.setOnClickListener {
                editListener.onEditClick()
                binding.commentMoreCard.visibility = View.INVISIBLE
            }

            binding.commentDelete.setOnClickListener {
                deleteListener.onDeleteClick()
                binding.commentMoreCard.visibility = View.INVISIBLE
            }

            binding.root.setOnClickListener {
                binding.commentMoreCard.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val current = comments[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int = comments.size
}