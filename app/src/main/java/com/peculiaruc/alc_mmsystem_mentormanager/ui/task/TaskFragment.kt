package com.peculiaruc.alc_mmsystem_mentormanager.ui.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Task
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.TaskAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.type.TaskStatus


class TaskFragment : BaseFragment<FragmentTaskBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_task
    override val viewModel: TaskViewModel by viewModels()
    private val args: TaskFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.task_title))
        viewModel.setType(args.taskType)
        onEvents()
        setBottomNavigationVisibility(false)
    }

    private fun onEvents() {
        val listTask = listOf(
            Task("", "", TaskStatus.ASSIGN),
            Task("test", "", TaskStatus.COMPLETED),
            Task("", "", TaskStatus.COMPLETED),
            Task("test", "", TaskStatus.ASSIGNED),
            Task("", "", TaskStatus.ASSIGN),
            Task("test", "", TaskStatus.ASSIGNED),
            Task("", "", TaskStatus.ASSIGN),
            Task("test", "", TaskStatus.ASSIGN),
            Task("", "", TaskStatus.COMPLETED),
            Task("test", "", TaskStatus.ASSIGNED),
            Task("", "", TaskStatus.ASSIGNED),
        )
        binding.recyclerViewTasks.adapter = TaskAdapter(listTask, viewModel)

        viewModel.taskEvent.observe(viewLifecycleOwner, EventObserve { type ->
            val list = when (type) {
                2 -> {
                    listTask.filter { it.status == TaskStatus.ASSIGN }
                }
                3 -> {
                    listTask.filter { it.status == TaskStatus.COMPLETED }

                }
                4 -> {
                    listTask.filter { it.status == TaskStatus.ASSIGN }
                }
                else -> {
                    listTask
                }
            }
            binding.recyclerViewTasks.adapter = TaskAdapter(list, viewModel)
        })

        viewModel.selectTaskEvent.observe(viewLifecycleOwner, EventObserve { task ->
            findNavController().navigate(TaskFragmentDirections.actionTaskFragmentToTaskDetailsFragment())
        })

        viewModel.createTaskEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(TaskFragmentDirections.actionTaskFragmentToTaskCreationFragment())
        })
    }


}