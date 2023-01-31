package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ChipDto
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.RoleDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegistrationThirdFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve

class RegistrationThirdFormFragment : BaseFragment<FragmentRegistrationThirdFormBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_registration_third_form
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        observeEvents()
    }

    private fun initData() {
        val chipsTechnicality = listOf(
            ChipDto(1, "Python"), ChipDto(2, "Java"), ChipDto(3, "Kotlin"),
            ChipDto(4, "Django"), ChipDto(5, "JavaScript"), ChipDto(6, "My SQL"),
            ChipDto(6, "Android"), ChipDto(6, "Swift"), ChipDto(6, "C++"),
        )

        val chipsRules = listOf(
            RoleDto(1, "Learner"), RoleDto(2, "Mentor"), RoleDto(3, "Program Assistant"),
            RoleDto(4, "Program Assistant Lead"), RoleDto(5, "Mentor Manager"),
        )
        chipsTechnicality.forEach {
            val chip = layoutInflater.inflate(
                R.layout.custom_chip_choice,
                binding.chipGroupTechnicalProficiency,
                false
            ) as Chip
            chip.text = it.name

            binding.chipGroupTechnicalProficiency.addView(chip)
        }

        chipsRules.forEach {
            val chip = layoutInflater.inflate(
                R.layout.custom_chip_choice,
                binding.chipGroupTechnicalProficiency,
                false
            ) as Chip
            chip.text = it.name

            binding.chipGroupPreviousRolesHeld.addView(chip)
        }
    }

    private fun observeEvents() {
        viewModel.registerPageEvent.observe(viewLifecycleOwner, EventObserve { page ->
            if (page == 4) {
                findNavController().navigate(RegistrationThirdFormFragmentDirections.actionRegistrationThirdFormFragmentToRegistrationForthFormFragment())
            } else {
                findNavController().navigateUp()
            }
        })
    }


}