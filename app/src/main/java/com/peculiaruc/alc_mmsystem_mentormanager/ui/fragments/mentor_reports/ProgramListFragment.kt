package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.ProgramListAdapter

class ProgramListFragment : Fragment() {
    private var _binding: FragmentProgramListBinding? = null
    private val binding
    get() = _binding!!

    private var isAllSelected = true
    private var isAssignedSelected = false
    private var isCompletedSelected = false
    private var isMyTaskSelected = false

    private val programs = arrayOf(
        "GADS Program 2022", "GADS Program 2022", "GADS Program 2022", "GADS Program 2022",
        "GADS Program 2022", "GADS Program 2022", "GADS Program 2022", "GADS Program 2022",
        "GADS Program 2022", "GADS Program 2022", "GADS Program 2022", "GADS Program 2022",
    )

    private val adapters = ProgramListAdapter(programs)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramListBinding.inflate(inflater, container, false)

        binding.programListToolbar.apply {
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

        binding.programList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        handleGroupButtonClick()

        return binding.root
    }

    private fun handleGroupButtonClick() {
        binding.programAll.setOnClickListener {
            isAllSelected = true
            isAssignedSelected = false
            isCompletedSelected = false
            isMyTaskSelected = false


            TextViewCompat.setTextAppearance(binding.programAll, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programMyTask, R.style.group_button_text)

            binding.programAssigned.background = null
            binding.programCompleted.background = null
            binding.programMyTask.background = null
            binding.programAll.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
        }

        binding.programAssigned.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = true
            isCompletedSelected = false
            isMyTaskSelected = false

            TextViewCompat.setTextAppearance(binding.programAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programMyTask, R.style.group_button_text)

            binding.programAssigned.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.programCompleted.background = null
            binding.programMyTask.background = null
            binding.programAll.background = null
        }

        binding.programCompleted.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = false
            isCompletedSelected = true
            isMyTaskSelected = false

            TextViewCompat.setTextAppearance(binding.programAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.programMyTask, R.style.group_button_text)

            binding.programAssigned.background = null
            binding.programCompleted.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.programMyTask.background = null
            binding.programAll.background = null
        }

        binding.programMyTask.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = false
            isCompletedSelected = false
            isMyTaskSelected = true

            TextViewCompat.setTextAppearance(binding.programAll, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.group_button_text)
            TextViewCompat.setTextAppearance(binding.programMyTask, R.style.group_button_text_selected)

            binding.programAssigned.background = null
            binding.programCompleted.background = null
            binding.programMyTask.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.programAll.background = null
        }
    }

}