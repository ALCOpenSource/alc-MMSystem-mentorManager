package com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/**
 * to implement the individual chats view model
 *
 */
class individual_chats_viewmodel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}