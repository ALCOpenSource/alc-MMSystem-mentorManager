package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.postDetails

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Comment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class CommentAdapter(
    items: List<Comment>,
    listener: CommentInteractionListener
) : BaseAdapter<Comment>(items, listener) {
    override val layoutID: Int = R.layout.item_comment
}

interface CommentInteractionListener : BaseInteractionListener {
    fun onItemCommentSelected(item: Comment)
}