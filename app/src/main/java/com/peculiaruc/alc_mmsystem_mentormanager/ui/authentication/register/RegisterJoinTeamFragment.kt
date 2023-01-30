package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterJoinTeamBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class RegisterJoinTeamFragment : BaseFragment<FragmentRegisterJoinTeamBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_register_join_team
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvent()
    }

    private fun observeEvent() {
        viewModel.registerMentorManagerEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(RegisterJoinTeamFragmentDirections.actionRegisterJoinTeamFragmentToRegisterMentorMangerFragment())
        })
    }


}