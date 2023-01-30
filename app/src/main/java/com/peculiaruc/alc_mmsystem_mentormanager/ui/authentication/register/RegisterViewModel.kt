package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class RegisterViewModel : ViewModel() {

    private val _registerMentorManagerEvent = MutableLiveData<Event<Boolean>>()
    val registerMentorManagerEvent: LiveData<Event<Boolean>> = _registerMentorManagerEvent

    fun onClickRegister() {
        _registerMentorManagerEvent.postValue(Event(true))
    }
}