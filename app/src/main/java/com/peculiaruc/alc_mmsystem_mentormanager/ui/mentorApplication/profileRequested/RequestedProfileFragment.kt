package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorApplication.profileRequested

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRequestedProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment


class RequestedProfileFragment : BaseFragment<FragmentRequestedProfileBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_requested_profile
    override val viewModel: RequestedProfileViewModel by viewModels()
    private val args: RequestedProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.profile_title))
        viewModel.setTypeComeFrom(args.type)
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        observeEvents()
    }

    private fun observeEvents() {

    }

}