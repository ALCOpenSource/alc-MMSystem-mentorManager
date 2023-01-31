package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.notification

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.NotificationDto
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class RegisterNotificationAdapter(items: List<NotificationDto>, listener: BaseInteractionListener) :
    BaseAdapter<NotificationDto>(items, listener) {
    override val layoutID: Int = R.layout.item_register_notification
}

