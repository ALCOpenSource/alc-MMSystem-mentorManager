package com.peculiaruc.alc_mmsystem_mentormanager.ui.program

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ProgramDto
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class ProgramMMAdapter(
    items: List<ProgramDto>,
    listener: ProgramMMAInteractionListener
) : BaseAdapter<ProgramDto>(items, listener) {
    override val layoutID: Int = R.layout.item_mm_program
}


interface ProgramMMAInteractionListener : BaseInteractionListener {
    fun onItemProgramSelected(item: ProgramDto)
}