package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.core.widget.TextViewCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.ProgramListAdapter
/**
 * loads the programs in the program list fragment
 */
class ProgramListFragment : Fragment() {
    private var _binding: FragmentProgramListBinding? = null
    private val binding
    get() = _binding!!

    // Toggle button states
    private var isAllSelected = true
    private var isAssignedSelected = false
    private var isCompletedSelected = false


    // Dummy data for the recycler view adapter
    private val programs = arrayOf(
        "GADS Program 20221", "GADS Program 20224", "GADS Program 20227", "GADS Program 202210",
        "GADS Program 20222", "GADS Program 20225", "GADS Program 20228", "GADS Program 202211",
        "GADS Program 20223", "GADS Program 20226", "GADS Program 20229", "GADS Program 202212",
    )

    private val adapters = ProgramListAdapter(programs)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramListBinding.inflate(inflater, container, false)

        // Back button pressed handler
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

    // This method handles the search icon click event
    private fun handleSearchClicked() {
        binding.programSearch.setOnSearchClickListener {
            binding.programSearch.isIconifiedByDefault = false
            binding.programSearch.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.programTitle.visibility = View.INVISIBLE
        }

        binding.programSearch.setOnCloseListener {
            binding.programSearch.background = null
            binding.programTitle.visibility = View.VISIBLE
            false
        }
    }

    // This method handles the toggle buttons selections
    private fun handleGroupButtonClick() {
        binding.programAll.setOnClickListener {
            // Group buttons state assigned
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