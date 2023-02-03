package com.peculiaruc.alc_mmsystem_mentormanager.ui.report.createReport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportCreationBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.ReportAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.report.ReportViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.task.TaskType
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class ReportCreationFragment : BaseFragment<FragmentReportCreationBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_report_creation
    override val viewModel: ReportCreationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.reports))
        setBottomNavigationVisibility(false)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.onClickSelectTaskEvent.observe(viewLifecycleOwner, EventObserve {
            if (viewModel.taskType.value == 1) {
                findNavController().navigate(ReportCreationFragmentDirections.actionReportCreationFragmentToProgramFragment())
            } else {
                val action =
                    ReportCreationFragmentDirections.actionReportCreationFragmentToTaskFragment()
                action.taskType = TaskType.ASSIGN_TASK.value
                findNavController().navigate(action)
            }
        })
    }


}