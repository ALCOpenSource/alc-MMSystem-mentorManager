package com.peculiaruc.alc_mmsystem_mentormanager.ui.report.createReport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ReportCreationViewModel : ViewModel() {

    private val _taskType = MutableLiveData(1)
    val taskType: LiveData<Int> = _taskType

    private val _onClickSelectTaskEvent = MutableLiveData<Event<Boolean>>()
    val onClickSelectTaskEvent: LiveData<Event<Boolean>> = _onClickSelectTaskEvent

    fun setTaskType(type: Int) {
        _taskType.postValue(type)
    }

    fun onClickSelectTask() {
        _onClickSelectTaskEvent.postValue(Event(true))
    }
}