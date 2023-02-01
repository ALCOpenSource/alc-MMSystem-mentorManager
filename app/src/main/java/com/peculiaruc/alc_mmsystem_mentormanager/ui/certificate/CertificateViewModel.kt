package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class CertificateViewModel : ViewModel() {

    private val _selectCertificateEvent = MutableLiveData<Event<CertificateStatus>>()
    val selectCertificateEvent: LiveData<Event<CertificateStatus>> = _selectCertificateEvent

    fun onClickCertificate(type: CertificateStatus) {
        _selectCertificateEvent.postValue(Event(type))
    }
}