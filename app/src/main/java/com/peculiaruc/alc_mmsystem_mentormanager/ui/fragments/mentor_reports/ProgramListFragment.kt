package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.core.widget.TextViewCompat
import androidx.navigation.Navigation
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

    private val programs = arrayOf(
        "GADS Program 2022 1", "GADS Program 2022 4", "GADS Program 2022 7", "GADS Program 2022 10",
        "GADS Program 2022 2", "GADS Program 2022 5", "GADS Program 2022 8", "GADS Program 2022 11",
        "GADS Program 2022 3", "GADS Program 2022 6", "GADS Program 2022 9", "GADS Program 2022 12",
    )

    private val adapters = ProgramListAdapter(programs)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramListBinding.inflate(inflater, container, false)

        binding.programBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.composeReportFragment, false)
        }

        handleSearchClicked()


        binding.programList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        handleGroupButtonClick()

        return binding.root
    }

    private fun handleSearchClicked() {
        binding.programSearch.setOnSearchClickListener {
            binding.programSearch.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.programTitle.visibility = View.INVISIBLE
        }

        binding.programSearch.setOnCloseListener {
            binding.programSearch.background = null
            binding.programTitle.visibility = View.VISIBLE
            false
        }
    }

    private fun handleGroupButtonClick() {
        binding.programAll.setOnClickListener {
            isAllSelected = true
            isAssignedSelected = false
            isCompletedSelected = false


            TextViewCompat.setTextAppearance(binding.programAll, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.program_group_button_text)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.program_group_button_text)

            binding.programAssigned.background = null
            binding.programCompleted.background = null
            binding.programAll.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
        }

        binding.programAssigned.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = true
            isCompletedSelected = false

            TextViewCompat.setTextAppearance(binding.programAll, R.style.program_group_button_text)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.group_button_text_selected)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.program_group_button_text)

            binding.programAssigned.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.programCompleted.background = null
            binding.programAll.background = null
        }

        binding.programCompleted.setOnClickListener {
            isAllSelected = false
            isAssignedSelected = false
            isCompletedSelected = true

            TextViewCompat.setTextAppearance(binding.programAll, R.style.program_group_button_text)
            TextViewCompat.setTextAppearance(binding.programAssigned, R.style.program_group_button_text)
            TextViewCompat.setTextAppearance(binding.programCompleted, R.style.group_button_text_selected)

            binding.programAssigned.background = null
            binding.programCompleted.background = ResourcesCompat.getDrawable(
                requireActivity().resources, R.drawable.group_button_background, null
            )
            binding.programAll.background = null
        }

    }

}