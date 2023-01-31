package com.peculiaruc.alc_mmsystem_mentormanager.ui.message

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Chat
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class ChatAdapter(
    items: List<Chat>,
    listener: ChatInteractionListener
) : BaseAdapter<Chat>(items, listener) {
    override val layoutID: Int = R.layout.item_chat
}


interface ChatInteractionListener : BaseInteractionListener {
    fun onItemChatSelected(item: Chat)
}