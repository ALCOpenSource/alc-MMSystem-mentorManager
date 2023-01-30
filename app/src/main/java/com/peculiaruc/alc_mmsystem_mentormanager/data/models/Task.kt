package com.peculiaruc.alc_mmsystem_mentormanager.data.models

import com.peculiaruc.alc_mmsystem_mentormanager.utilities.type.TaskStatus

/**
 *  represent the Task object that will come from api .
 */
data class Task(val title: String, val time: String, val status: TaskStatus) : Item()