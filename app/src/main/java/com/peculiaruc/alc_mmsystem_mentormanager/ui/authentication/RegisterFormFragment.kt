package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentHomeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.home.HomeViewModel


class RegisterFormFragment : BaseFragment<FragmentRegisterFormBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_register_form
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setBottomNavigationVisibility(true)

    }

}