package com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile

/**
 * MMM-Team-7
 * This is a data class use to generate dummy data for the mentor list recycler view
 */

data class mentor_list (
    val name : String ="",
    val Bio_data : String ="",
    val Title : String ="",
    val Role : String ="",
    val profile_pic : Int,
    val assignne:Boolean
)