package com.peculiaruc.alc_mmsystem_mentormanager.ui.task.taskCreation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class TaskCreationViewModel : ViewModel() {

    private val _selectMentorEvent = MutableLiveData<Event<Boolean>>()
    val selectMentorEvent: LiveData<Event<Boolean>> = _selectMentorEvent


    fun onClickSelectMentor() {
        _selectMentorEvent.postValue(Event(true))
    }
}