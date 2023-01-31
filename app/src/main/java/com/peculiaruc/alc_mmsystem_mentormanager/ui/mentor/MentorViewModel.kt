package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class MentorViewModel : ViewModel(), MentorInteractionListener {

    private val _selectItemMange = MutableLiveData<Event<Mentor>>()
    val selectItemMange: LiveData<Event<Mentor>> = _selectItemMange

    private val _addMentorEvent = MutableLiveData<Event<Boolean>>()
    val addMentorEvent: LiveData<Event<Boolean>> = _addMentorEvent

    /**
     * done when the add mentor button is clicked
     */
    fun addMentorManger() {
        _addMentorEvent.postValue(Event(true))
    }

    override fun onItemMentorSelected(item: Mentor) {
        _selectItemMange.postValue(Event(item))
    }
}