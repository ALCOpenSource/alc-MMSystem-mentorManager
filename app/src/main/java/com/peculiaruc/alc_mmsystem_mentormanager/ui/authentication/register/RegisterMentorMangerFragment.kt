package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterJoinTeamBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterMentorMangerBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment


class RegisterMentorMangerFragment : BaseFragment<FragmentRegisterMentorMangerBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_register_mentor_manger
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
    }


}