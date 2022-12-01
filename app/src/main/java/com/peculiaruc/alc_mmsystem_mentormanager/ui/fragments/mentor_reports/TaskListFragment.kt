package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.TaskListAdapter


class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null
    private val binding
        get() = _binding!!

    // Toggle button states
    private var isAllSelected = true
    private var isAssignedSelected = false
    private var isCompletedSelected = false
    private var isMyTaskSelected = false

    // Dummy data for the recycler view adapter
    private val tasks = arrayOf(
        "Room library article write", "Room library article write",
        "Room library article write", "Room library article write",
        "Room library article write", "Room library article write",
        "Room library article write", "Room library article write",
    )

    private val adapters = TaskListAdapter(tasks)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)

        // Back button pressed handler
        binding.taskBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.composeReportFragment, false)
        }

        handleSearchClicked()

        binding.taskList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        handleGroupButtonClick()

        return binding.root
    }

    // This method handles the search icon click event
    private fun handleSearchClicked() {
        binding.taskSearch.setOnSearchClickListener {
            binding.taskSearch.isIconifiedByDefault = false
            binding.taskSearch.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.taskTitle.visibility = View.INVISIBLE
        }

        binding.taskSearch.setOnCloseListener {
            binding.taskSearch.background = null
            binding.taskTitle.visibility = View.VISIBLE
            false
        }
    }

    // This method handles the toggle buttons selections
    private fun handleGroupButtonClick() {
        binding.taskAll.setOnClickListener {
            // Group buttons state assigned
            isAllSelected = true
            isAssignedSelected = false
            isCompletedSelected = false
            isMyTaskSelected = false


            TextViewCompat.setTextAppearance(binding.taskAll, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.taskAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskMyTask, R.style.group_button_text)

            binding.taskAssigned.background = null
            binding.taskCompleted.background = null
            binding.taskMyTask.background = null
            binding.taskAll.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
        }

        binding.taskAssigned.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = true
            isCompletedSelected = false
            isMyTaskSelected = false

            TextViewCompat.setTextAppearance(binding.taskAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskAssigned, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.taskCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskMyTask, R.style.group_button_text)

            binding.taskAssigned.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.taskCompleted.background = null
            binding.taskMyTask.background = null
            binding.taskAll.background = null
        }

        binding.taskCompleted.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = false
            isCompletedSelected = true
            isMyTaskSelected = false

            TextViewCompat.setTextAppearance(binding.taskAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskCompleted, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.taskMyTask, R.style.group_button_text)

            binding.taskAssigned.background = null
            binding.taskCompleted.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.taskMyTask.background = null
            binding.taskAll.background = null
        }

        binding.taskMyTask.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = false
            isCompletedSelected = false
            isMyTaskSelected = true

            TextViewCompat.setTextAppearance(binding.taskAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.taskMyTask, R.style.group_button_text_selected)

            binding.taskAssigned.background = null
            binding.taskCompleted.background = null
            binding.taskMyTask.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.taskAll.background = null
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}