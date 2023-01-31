package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.TaskDetails
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve

/**
 * task details fragment to display the task details
 */
class TaskDetailsFragment : BaseFragment<FragmentTaskDetailsBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_task_details
    override val viewModel: TaskViewModel by viewModels()

    //Just For Test
    private val list = listOf(
        TaskDetails("Mentor Managers assigned to this Task", 12),
        TaskDetails("Mentor Managers assigned to this Task", 12),
        TaskDetails("Task Reports", 12),
        TaskDetails("Task Reports", 12),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.task_title))
        setBottomNavigationVisibility(false)
        binding.taskRecycler.adapter = TaskDetailsAdapter(list, viewModel)
        onEvents()
    }

    private fun onEvents() {
        viewModel.assignToTaskEvent.observe(viewLifecycleOwner, EventObserve {
//            val type = if (it) {
//                DialogTypes.UNASSIGNED_TASK
//            } else {
//                DialogTypes.ASSIGNED_TASK
//            }
//            findNavController().navigate(
//                TaskDetailsFragmentDirections.actionTaskDetailsFragmentToBasicDialog(type)
//            )
//            viewModel.setAssigned(!it)
        })

        viewModel.viewTaskEvent.observe(viewLifecycleOwner, EventObserve {
            Toast.makeText(requireContext(), "Open another Fragment", Toast.LENGTH_LONG).show()
        })
    }
}