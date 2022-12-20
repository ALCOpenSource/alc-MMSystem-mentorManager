package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEmptyNotificationsBinding

/**
 * screen displayed when there are empty notifications
 */
class EmptyNotificationsFragment : Fragment() {

 private lateinit var binding:FragmentEmptyNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEmptyNotificationsBinding.inflate(inflater)

        binding.btnBackHome.setOnClickListener {
            val action = EmptyNotificationsFragmentDirections.actionEmptyNotificationsFragmentToHomeFragment()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}