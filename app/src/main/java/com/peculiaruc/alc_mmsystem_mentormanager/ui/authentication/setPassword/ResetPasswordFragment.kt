package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.setPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentForgetPasswordBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentResetPasswordBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.forgetPassword.ForgetPasswordViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment


class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_reset_password
    override val viewModel: ResetPasswordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
    }

    private fun observeEvent() {

    }

}