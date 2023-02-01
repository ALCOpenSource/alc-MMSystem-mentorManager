package com.peculiaruc.alc_mmsystem_mentormanager.ui.manager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentManagerBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class ManagerFragment : BaseFragment<FragmentManagerBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_manager
    override val viewModel: ManagerViewModel by viewModels()

    //********************For Text*****************\\
    val list = listOf(
        Mentor("asd1", "", "", listOf()),
        Mentor("asd2", "", "", listOf()),
        Mentor("asd3", "", "", listOf()),
        Mentor("asd4", "", "", listOf()),
        Mentor("asd5", "", "", listOf()),
        Mentor("asd6", "", "", listOf()),
        Mentor("asd7", "", "", listOf()),
        Mentor("asd8", "", "", listOf()),
        Mentor("asd9", "", "", listOf()),
    )
    //*******************************************\\

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.managers_title))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        binding.recyclerManager.adapter = MentorAdapter(list, viewModel)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.selectManager.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(ManagerFragmentDirections.actionManagerFragmentToAdminProfileFragment())
        })
    }


}