package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Task
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener

/**
 * task adapter class for the Mentor Manger Profile fragment
 */
class TaskAdapter(
    items: List<Task>,
    listener: TaskInteractionListener
) : BaseAdapter<Task>(items, listener) {
    override val layoutID: Int = R.layout.item_task
}

/**
 * task interaction listener for the Mentor Manger Profile fragment
 */
interface TaskInteractionListener : BaseInteractionListener {
    /**
     * done when the task item is clicked
     */
    fun onItemTaskSelected(item: Task)
}