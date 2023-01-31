package com.peculiaruc.alc_mmsystem_mentormanager.ui.program

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ProgramViewModel : ViewModel(), ProgramMMAInteractionListener {


    private val _allProgramEvent = MutableLiveData<Event<Boolean>>()
    val allProgramEvent: LiveData<Event<Boolean>> = _allProgramEvent

    private val _assignedProgramEvent = MutableLiveData<Event<Boolean>>()
    val assignedProgramEvent: LiveData<Event<Boolean>> = _assignedProgramEvent

    private val _completedProgramEvent = MutableLiveData<Event<Boolean>>()
    val completedProgramEvent: LiveData<Event<Boolean>> = _completedProgramEvent

    override fun onItemProgramSelected(item: Certificate) {
        TODO("Not yet implemented")
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