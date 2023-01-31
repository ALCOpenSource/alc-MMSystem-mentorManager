package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseInteractionListener


class DocumentAdapter(
    items: List<DocumentDto>,
    listener: DocumentInteractionListener
) : BaseAdapter<DocumentDto>(items, listener) {
    override val layoutID: Int = R.layout.item_document
}


interface DocumentInteractionListener : BaseInteractionListener {
    fun onItemDocumentSelected(item: Certificate)
}