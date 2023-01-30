package com.peculiaruc.alc_mmsystem_mentormanager.data.models


/**
 *  represent the Mentor object that will come from api .
 */
data class Mentor(
    val name: String,
    val image: String,
    val role: String,
    val tags: List<String>
)