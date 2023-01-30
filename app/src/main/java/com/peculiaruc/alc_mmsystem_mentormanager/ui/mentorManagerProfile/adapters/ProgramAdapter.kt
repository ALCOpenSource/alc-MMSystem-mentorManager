package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters

import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Program
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener

/**
 * Program adapter class for the Mentor Manger Profile fragment
 */
class ProgramAdapter(items: List<Program>, listener: ProgramInteractionListener) :
    BaseAdapter<Program>(items, listener) {
    override val layoutID: Int = R.layout.item_program
}

/**
 * Program interaction listener for the Mentor Manger Profile fragment
 */
interface ProgramInteractionListener : BaseInteractionListener {

    /**
     * done when the Program item is clicked
     */
    fun onProgramSelected(item: Program)
}