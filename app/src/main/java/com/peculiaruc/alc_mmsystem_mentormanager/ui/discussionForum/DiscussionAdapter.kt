package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.BeneficiaryMember
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Discussion
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class DiscussionAdapter(
    items: List<Discussion>,
    listener: DiscussionInteractionListener
) : BaseAdapter<Discussion>(items, listener) {
    override val layoutID: Int = R.layout.item_forum
}

interface DiscussionInteractionListener : BaseInteractionListener {
    fun onItemEditDiscussionSelected(item: Discussion)
    fun onItemCommentOnPostSelected(item: Discussion)


}