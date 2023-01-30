package com.peculiaruc.alc_mmsystem_mentormanager.data.models

/**
 *  represent the ProgramDetails object that will come from api .
 */
data class ProgramDetails(
    val programName: String,
    val programImage: String,
    val about: String,
    val isAssigned: Boolean,
    val mentorMangersList: List<MentorMangersProgram>
)

