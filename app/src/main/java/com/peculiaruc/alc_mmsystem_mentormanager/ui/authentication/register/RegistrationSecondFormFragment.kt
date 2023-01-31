package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterationSecondFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class RegistrationSecondFormFragment : BaseFragment<FragmentRegisterationSecondFormBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_registeration_second_form
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.registerPageEvent.observe(viewLifecycleOwner, EventObserve { page ->
            if (page == 3) {
                findNavController().navigate(RegistrationSecondFormFragmentDirections.actionRegistrationSecondFormFragmentToRegistrationThirdFormFragment())
            } else {
                findNavController().navigateUp()
            }
        })
    }


}