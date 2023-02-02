package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.beneficiary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.BeneficiaryMember
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class CertificateBeneficiaryViewModel : ViewModel(), BeneficiaryMemberInteractionListener {

    private val _selectMemberEvent = MutableLiveData<Event<BeneficiaryMember>>()
    val selectMemberEvent: LiveData<Event<BeneficiaryMember>> = _selectMemberEvent


    override fun onItemMemberSelected(item: BeneficiaryMember) {
        _selectMemberEvent.postValue(Event(item))
    }
}