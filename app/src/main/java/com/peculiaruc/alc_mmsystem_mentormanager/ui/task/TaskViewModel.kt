package com.peculiaruc.alc_mmsystem_mentormanager.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Task
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.TaskInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class TaskViewModel : ViewModel(), TaskInteractionListener {

    private val _taskEvent = MutableLiveData<Event<Int>>()
    val taskEvent: LiveData<Event<Int>> = _taskEvent


    fun onSelectTask(type: Int) {
        _taskEvent.postValue(Event(type))
    }

    override fun onItemTaskSelected(item: Task) {
        TODO("Not yet implemented")
    }
}