package com.peculiaruc.alc_mmsystem_mentormanager.ui.chat.broadcastMessages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * To implement the viw model for broadcast messages screen
 */
class BroadcastMessagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}