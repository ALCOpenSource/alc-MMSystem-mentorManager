package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class CertificateViewModel : ViewModel() {

    private val _selectCertificateEvent = MutableLiveData<Event<CertificateStatus>>()
    val selectCertificateEvent: LiveData<Event<CertificateStatus>> = _selectCertificateEvent

    private val _selectGenerateCertificateEvent = MutableLiveData<Event<Boolean>>()
    val selectGenerateCertificateEvent: LiveData<Event<Boolean>> = _selectGenerateCertificateEvent


    fun onClickCertificate(type: CertificateStatus) {
        _selectCertificateEvent.postValue(Event(type))
    }

    fun onClickGenerateCertificate() {
        _selectGenerateCertificateEvent.postValue(Event(true))
    }
}