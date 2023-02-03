package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.forgetPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ForgetPasswordViewModel : ViewModel() {

    private val _doneEvent = MutableLiveData<Event<Boolean>>()
    val doneEvent: LiveData<Event<Boolean>> = _doneEvent


    fun onClickDone() {
        _doneEvent.postValue(Event(true))
    }
}