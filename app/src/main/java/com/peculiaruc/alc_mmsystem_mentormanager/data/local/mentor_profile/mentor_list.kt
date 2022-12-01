package com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile

// data class to hold the list of mentors to be displayed in the fragment mentor_list screen

data class mentor_list (
    val name : String ="",
    val Bio_data : String ="",
    val Title : String ="",
    val Role : String ="",
    val profile_pic : Int,
    val assignne:Boolean
)