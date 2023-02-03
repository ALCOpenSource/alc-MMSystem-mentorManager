package com.peculiaruc.alc_mmsystem_mentormanager.ui.task.taskCreation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskCreationBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.task.TaskViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class TaskCreationFragment : BaseFragment<FragmentTaskCreationBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_task_creation
    override val viewModel: TaskCreationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.task_title))
        setBottomNavigationVisibility(false)
        onEvents()
    }

    private fun onEvents() {
        viewModel.selectMentorEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(TaskCreationFragmentDirections.actionTaskCreationFragmentToTaskAssigningMentorFragment())
        })

    }

}