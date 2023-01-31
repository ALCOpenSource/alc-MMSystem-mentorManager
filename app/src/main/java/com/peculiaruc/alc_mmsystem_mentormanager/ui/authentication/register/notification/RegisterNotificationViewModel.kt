package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class RegisterNotificationViewModel : ViewModel(), BaseInteractionListener {

    private val _registerNotificationEvent = MutableLiveData<Event<Boolean>>()
    val registerNotificationEvent: LiveData<Event<Boolean>> = _registerNotificationEvent

    fun onClickContinue() {
        _registerNotificationEvent.postValue(Event(true))
    }

}