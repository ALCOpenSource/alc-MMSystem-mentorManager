package com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages

// data class to hold chat list to be displayed in the individual chat fragment messages screen
data class individual_chat_messages(
    val name: String ="",
    val message: String ="",
    val receive: Int,
    val chat_time: String ="",
    val profile_pic: Int
)
