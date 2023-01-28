package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentHomeBinding

/**
 * shows the home dashboard
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

//        binding.btnNotifications.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToEmptyNotificationsFragment()
//            it.findNavController().navigate(action)
//        }
//
//        binding.btnMentorApplication.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToMentorApplicants()
//            it.findNavController().navigate(action)
//        }


        return binding.root
    }

}