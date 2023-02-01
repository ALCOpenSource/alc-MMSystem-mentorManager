package com.peculiaruc.alc_mmsystem_mentormanager.ui.manager.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentAdminProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class AdminProfileFragment : BaseFragment<FragmentAdminProfileBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_admin_profile
    override val viewModel: AdminProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.profile_title))
        setBottomNavigationVisibility(false)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.openLinkEvent.observe(viewLifecycleOwner) {
            if (!it.isNullOrBlank()) {
                openURL(it)
            }
        }

        viewModel.clickMessage.observe(viewLifecycleOwner, EventObserve {
            // go to message...
        })
    }

    private fun openURL(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}