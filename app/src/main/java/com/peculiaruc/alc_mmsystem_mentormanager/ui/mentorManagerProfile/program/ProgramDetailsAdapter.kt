package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.program

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.MentorMangersProgram
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener

/**
 * program details adapter class for the program details fragment
 */
class ProgramDetailsAdapter(
    items: List<MentorMangersProgram>,
    listener: ProgramDetailInteractionListener
) : BaseAdapter<MentorMangersProgram>(items, listener) {
    override val layoutID: Int = R.layout.item_program_details
}

/**
 * program details interaction listener for the program details fragment
 */
interface ProgramDetailInteractionListener : BaseInteractionListener {

    /**
     * done when the task details item is viewed
     */
    fun onProgramDetailsView(item: MentorMangersProgram)
}