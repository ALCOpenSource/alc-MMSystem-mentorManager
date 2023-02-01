package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorApplication.profileRequested

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RequestedProfileViewModel : ViewModel() {

    private val _editVisibility = MutableLiveData<Int>()
    val editVisibility: LiveData<Int> = _editVisibility

    fun setTypeComeFrom(type: Int) {
        _editVisibility.postValue(type)
    }
}