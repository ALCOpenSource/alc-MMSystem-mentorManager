package com.peculiaruc.alc_mmsystem_mentormanager.utilities.event

import androidx.lifecycle.Observer

class EventObserve<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}