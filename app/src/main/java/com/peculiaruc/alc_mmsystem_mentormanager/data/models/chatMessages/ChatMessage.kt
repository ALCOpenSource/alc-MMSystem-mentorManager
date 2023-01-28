package com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages

/**
 * MMM-Team-7
 * This is a data class use to generate dummy data for the chat screen recycler view
 */

data class ChatMessage (
    val name : String ="",
    val message : String ="",
    val creationTime : String ="",
    val number : String ="",
    val profilePic : Int
)