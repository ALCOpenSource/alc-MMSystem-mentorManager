package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.forgetPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentForgetPasswordBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterJoinTeamBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.RegisterViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class ForgetPasswordFragment : BaseFragment<FragmentForgetPasswordBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_forget_password
    override val viewModel: ForgetPasswordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
    }

    private fun observeEvent() {
        viewModel.doneEvent.observe(viewLifecycleOwner, EventObserve {

        })
    }

}