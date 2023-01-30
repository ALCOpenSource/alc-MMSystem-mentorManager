package com.peculiaruc.alc_mmsystem_mentormanager.utilities.event

open class Event<out T>(private val content: T) {

    fun peekContent(): T = content

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

}