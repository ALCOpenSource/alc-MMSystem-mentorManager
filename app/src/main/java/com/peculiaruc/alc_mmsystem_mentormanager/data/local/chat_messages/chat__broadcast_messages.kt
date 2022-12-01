package com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages

// data class to hold list of messages to be displayed in the broadcast screen

data class chat__broadcast_messages(
    val name: String ="",
    val message: String ="",
    val receive: Int,
    val chat_time: String ="",
    val profile_pic: Int
)
