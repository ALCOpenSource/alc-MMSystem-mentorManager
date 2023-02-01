package com.peculiaruc.alc_mmsystem_mentormanager.ui.manager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ManagerViewModel : ViewModel(), MentorInteractionListener {

    private val _selectManager = MutableLiveData<Event<Mentor>>()
    val selectManager: LiveData<Event<Mentor>> = _selectManager

    override fun onItemMentorSelected(item: Mentor) {
        _selectManager.postValue(Event(item))
    }
}