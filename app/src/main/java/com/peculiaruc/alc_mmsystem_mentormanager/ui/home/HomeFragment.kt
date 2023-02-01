package com.peculiaruc.alc_mmsystem_mentormanager.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentHomeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.MainActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setBottomNavigationVisibility(true)
        onEvents()
    }

    private fun onEvents() {
        viewModel.notificationEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToNotificationFragment()
            )
        })

        viewModel.drawerEvent.observe(viewLifecycleOwner, EventObserve {
            (requireActivity() as MainActivity).openDrawer()
        })

        viewModel.viewMMEvent.observe(viewLifecycleOwner, EventObserve {
//            findNavController().navigate(
//                HomeFragmentDirections
//                    .actionHomeFragmentToMentorMangerFragment()
//            )
        })

        viewModel.viewMentorsEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Mentors Fragment
        })

        viewModel.viewProgramsEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Programs Fragment
        })

        viewModel.createTaskEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Create Task Fragment
        })

        viewModel.sentBroadcastEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Sent Broadcast Fragment
        })

        viewModel.addMentorManagerEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Add Mentor Manager Fragment
        })

        viewModel.addMentorEvent.observe(viewLifecycleOwner, EventObserve {
            // TODO: Navigate to Add Mentor Fragment
        })

        viewModel.clickMentorEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMentorApplicationFragment())
        })
    }
}