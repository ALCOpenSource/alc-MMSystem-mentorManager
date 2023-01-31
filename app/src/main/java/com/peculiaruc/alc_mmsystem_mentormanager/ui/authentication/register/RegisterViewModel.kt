package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class RegisterViewModel : ViewModel(), DocumentInteractionListener {

    private val _registerMentorManagerEvent = MutableLiveData<Event<Boolean>>()
    val registerMentorManagerEvent: LiveData<Event<Boolean>> = _registerMentorManagerEvent

    private val _registerPagerEvent = MutableLiveData<Event<Int>>()
    val registerPageEvent: LiveData<Event<Int>> = _registerPagerEvent

    fun onClickRegister() {
        _registerMentorManagerEvent.postValue(Event(true))
    }

    fun goToFirstRegistrationForm() {
        _registerPagerEvent.postValue(Event(1))
    }

    fun goToSecondRegistrationForm() {
        _registerPagerEvent.postValue(Event(2))
    }

    fun goToThirdRegistrationForm() {
        _registerPagerEvent.postValue(Event(3))
    }

    fun goToForthRegistrationForm() {
        _registerPagerEvent.postValue(Event(4))
    }

    fun goToNotification() {
        _registerPagerEvent.postValue(Event(5))
    }

    override fun onItemDocumentSelected(item: Certificate) {
    }

}