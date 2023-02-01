package com.peculiaruc.alc_mmsystem_mentormanager.ui.manager.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class AdminProfileViewModel : ViewModel() {

    private val _openLinkEvent = MutableLiveData<String>()
    val openLinkEvent: LiveData<String> = _openLinkEvent

    private val _clickMessage = MutableLiveData<Event<Boolean>>()
    val clickMessage: LiveData<Event<Boolean>> = _clickMessage

    fun onClickGithub() {
        _openLinkEvent.postValue("https://github.com/")
    }

    fun onClickLinkedIn() {
        _openLinkEvent.postValue("https://www.linkedin.com/feed/")
    }

    fun onClickInstagram() {
        _openLinkEvent.postValue("https://www.instagram.com/")
    }

    fun onClickTwitter() {
        _openLinkEvent.postValue("https://twitter.com/home")
    }

    fun onClickMessage() {
        _clickMessage.postValue(Event(true))
    }
}