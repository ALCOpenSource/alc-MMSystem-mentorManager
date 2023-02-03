package com.peculiaruc.alc_mmsystem_mentormanager.ui.report

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Report
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.ReportInteractionListener
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class ReportViewModel : ViewModel(), ReportInteractionListener {

    private val _downloadReportEvent = MutableLiveData<Event<Report>>()
    val downloadReportEvent: LiveData<Event<Report>> = _downloadReportEvent

    private val _shareReportEvent = MutableLiveData<Event<Report>>()
    val shareReportEvent: LiveData<Event<Report>> = _shareReportEvent

    private val _openReportDetailsEvent = MutableLiveData<Event<Report>>()
    val openReportDetailsEvent: LiveData<Event<Report>> = _openReportDetailsEvent

    private val _addReportEvent = MutableLiveData<Event<Boolean>>()
    val addReportEvent: LiveData<Event<Boolean>> = _addReportEvent

    fun addReport() {
        _addReportEvent.postValue(Event(true))
    }

    override fun onItemReportShare(item: Report) {
        _shareReportEvent.postValue(Event(item))
    }

    override fun onItemReportDownload(item: Report) {
        _downloadReportEvent.postValue(Event(item))
    }

    override fun onItemClick(item: Report) {
        _openReportDetailsEvent.postValue(Event(item))
    }
}