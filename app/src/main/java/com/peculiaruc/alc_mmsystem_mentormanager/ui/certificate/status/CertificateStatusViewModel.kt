package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.status

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.CertificateStatus
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.CertificateInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class CertificateStatusViewModel : ViewModel(), CertificateInteractionListener {

    private val _selectCertificateEvent = MutableLiveData<Event<Certificate>>()
    val selectCertificateEvent: LiveData<Event<Certificate>> = _selectCertificateEvent

    override fun onItemCertificateSelected(item: Certificate) {
        _selectCertificateEvent.postValue(Event(item))
    }
}