package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuProvider
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null
    private val binding
        get() = _binding!!

    private var isAllSelected = true
    private var isAssignedSelected = false
    private var isCompletedSelected = false
    private var isMyTaskSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)

        binding.taskListToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_item, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return true
                }

            })
        }

        handleGroupButtonClick()

        return binding.root
    }

    private fun handleGroupButtonClick() {
        binding.taskAll.setOnClickListener {
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