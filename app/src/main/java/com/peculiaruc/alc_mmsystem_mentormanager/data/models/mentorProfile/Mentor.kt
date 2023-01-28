package com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile

/**
 * MMM-Team-7
 * This is a data class use to generate dummy data for the mentor list recycler view
 */

data class Mentor(
    val name: String = "",
    val bioData: String = "",
    val title: String = "",
    val role: String = "",
    val profilePic: Int,
    val assign: Boolean
)