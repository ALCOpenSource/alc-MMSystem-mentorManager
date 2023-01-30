package com.peculiaruc.alc_mmsystem_mentormanager.ui.notification

import android.view.View
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Notification
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener

/**
 * Notification adapter class for the Notification
 */
class NotificationAdapter(items: List<Notification>, listener: NotificationInteractionListener) :
    BaseAdapter<Notification>(items, listener) {
    override val layoutID: Int = R.layout.item_notification
}

/**
 * Notification  interaction listener for the Notification
 */
interface NotificationInteractionListener : BaseInteractionListener {
    /**
     * done when the Notification item is Clicked
     */
    fun onNotificationClick(item: Notification, view: View)
}