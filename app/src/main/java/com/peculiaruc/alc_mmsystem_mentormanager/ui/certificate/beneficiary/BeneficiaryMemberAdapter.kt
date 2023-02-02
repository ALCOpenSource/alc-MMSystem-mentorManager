package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.beneficiary

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.BeneficiaryMember
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener

class BeneficiaryMemberAdapter(
    items: List<BeneficiaryMember>,
    listener: BeneficiaryMemberInteractionListener
) : BaseAdapter<BeneficiaryMember>(items, listener) {
    override val layoutID: Int = R.layout.item_beneficiary_member
}

interface BeneficiaryMemberInteractionListener : BaseInteractionListener {

    fun onItemMemberSelected(item: BeneficiaryMember)
}