package com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages

// data class to hold convesation to be displayed in the chat messages screen

data class chat_messages (
    val name : String ="",
    val message : String ="",
    val creation_time : String ="",
    val number : String ="",
    val profile_pic : Int
)