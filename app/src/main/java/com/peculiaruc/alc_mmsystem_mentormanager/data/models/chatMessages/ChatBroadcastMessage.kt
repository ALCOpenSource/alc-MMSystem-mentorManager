package com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages

/**
 * MMM-Team-7
 * This is a data class use to generate dummy data for the broadcast screen recycler view
 */

data class ChatBroadcastMessage(
    val name: String ="",
    val message: String ="",
    val receive: Int,
    val chatTime: String ="",
    val profilePic: Int
)
