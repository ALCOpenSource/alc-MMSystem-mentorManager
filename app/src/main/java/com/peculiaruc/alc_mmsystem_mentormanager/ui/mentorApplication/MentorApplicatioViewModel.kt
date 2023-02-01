package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorApplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class MentorApplicationViewModel : ViewModel(), MentorInteractionListener {

    private val _selectMentor = MutableLiveData<Event<Mentor>>()
    val selectMentor: LiveData<Event<Mentor>> = _selectMentor

    override fun onItemMentorSelected(item: Mentor) {
        _selectMentor.postValue(Event(item))
    }

    fun addMentorManger() {

    }
}