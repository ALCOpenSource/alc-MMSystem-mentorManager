package com.peculiaruc.alc_mmsystem_mentormanager.ui.task.taskMentor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class TaskAssigningMentorViewModel : ViewModel(), MentorInteractionListener {

    private val _selectMentorEvent = MutableLiveData<Event<Mentor>>()
    val selectMentorEvent: LiveData<Event<Mentor>> = _selectMentorEvent

    private val _doneSelectionEvent = MutableLiveData<Event<Boolean>>()
    val doneSelectionEvent: LiveData<Event<Boolean>> = _doneSelectionEvent

    override fun onItemMentorSelected(item: Mentor) {
        _selectMentorEvent.postValue(Event(item))
    }


    fun onClickDone() {
        _doneSelectionEvent.postValue(Event(true))
    }


}