package com.peculiaruc.alc_mmsystem_mentormanager.data.models

import com.peculiaruc.alc_mmsystem_mentormanager.utilities.type.ProgramProgress

/**
 *  represent the Program object that will come from api .
 */
data class Program(
    val programTitle: String,
    val programDate: String,
    val progress: ProgramProgress
) : Item()