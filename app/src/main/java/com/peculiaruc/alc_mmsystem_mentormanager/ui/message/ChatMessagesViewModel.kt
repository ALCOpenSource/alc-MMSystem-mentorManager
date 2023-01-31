package com.peculiaruc.alc_mmsystem_mentormanager.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Chat
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ChatMessagesViewModel : ViewModel(), ChatInteractionListener {

    private val _selectConversationEvent = MutableLiveData<Event<Chat>>()
    val selectConversationEvent: LiveData<Event<Chat>> = _selectConversationEvent

    override fun onItemChatSelected(item: Chat) {
        _selectConversationEvent.postValue(Event(item))
    }
}