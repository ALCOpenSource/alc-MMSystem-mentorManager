package com.peculiaruc.alc_mmsystem_mentormanager.ui.program

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ProgramDto
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ProgramViewModel : ViewModel(), ProgramMMAInteractionListener {


    private val _allProgramEvent = MutableLiveData<Event<Boolean>>()
    val allProgramEvent: LiveData<Event<Boolean>> = _allProgramEvent

    private val _assignedProgramEvent = MutableLiveData<Event<Boolean>>()
    val assignedProgramEvent: LiveData<Event<Boolean>> = _assignedProgramEvent

    private val _completedProgramEvent = MutableLiveData<Event<Boolean>>()
    val completedProgramEvent: LiveData<Event<Boolean>> = _completedProgramEvent

    private val _selectProgramEvent = MutableLiveData<Event<ProgramDto>>()
    val selectProgramEvent: LiveData<Event<ProgramDto>> = _selectProgramEvent

    override fun onItemProgramSelected(item: ProgramDto) {
        _selectProgramEvent.postValue(Event(item))
    }

    fun onClickAllProgram() {
        _allProgramEvent.postValue(Event(true))
    }

    fun onClickAssignedProgram() {
        _assignedProgramEvent.postValue(Event(true))
    }

    fun onClickCompletedProgram() {
        _completedProgramEvent.postValue(Event(true))
    }

}